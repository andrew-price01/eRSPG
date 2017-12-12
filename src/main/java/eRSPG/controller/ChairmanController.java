package eRSPG.controller;

import eRSPG.Repository.*;
import eRSPG.model.*;
import eRSPG.model.form.AnnouncementForm;
import eRSPG.model.form.BudgetDetails;
import eRSPG.model.form.DepartmentForm;
import eRSPG.model.form.ManageBudgetForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Controller
@SessionAttributes({"AnnouncementForm", "ManageBudgetForm", "BudgetDetails"})
public class ChairmanController {

    @Autowired
    private ProposalDAO proposalDao;

    @Autowired
    private AnnouncementDAO announcementDao;

    @Autowired
    private ReviewerDAO reviewerDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private ProposalStatusDAO proposalStatusDAO;

    @Autowired
    private SemesterDAO semesterDAO;

    @Autowired
    private BudgetDAO budgetDAO;

//TODO wak!
    @RequestMapping("/eRSPG/chair/changeChair")
    public String changeChairman(Model model) {
        String contentPage = "changeChairman.jsp";
        model.addAttribute("contentPage",contentPage);
        return "projectIndex";
    }
//
//    @RequestMapping("/chair/createAnnouncement")
//    public String createAnnouncement(Model model) {
//        String contentPage = "createAnnouncement.jsp";
//        model.addAttribute("contentPage", contentPage);
//        return "projectIndex";
//    }

    @RequestMapping("/eRSPG/chair/home")
    public String chairmanHome() {
        return "chairmanHome";
    }

    @RequestMapping("/eRSPG/chair/makeAnnouncement")
    public String makeAnnouncement() {
        return "makeAnnouncement";
    }

    @RequestMapping("/eRSPG/chair/proposal")
    public String chairmanProposal() {
        return "chairmanProposalHome";
    }

    @RequestMapping("/eRSPG/chair/committee")
    public String chairmanCommittee() {
        return "manageCommittee";
    }

    @RequestMapping("/eRSPG/chair/assignproposal")
    public String chairmanAssignProposal() {
        return "assignProposal";
    }

    @RequestMapping("/eRSPG/chair/announcementSuccess")
    public String chairmanAnnouncmentSuccess() { return "announcementSuccess"; };

    @RequestMapping("/eRSPG/chair/reviewproposal")
    public String chairmanReviewProposal() { return "chairmanReviewProposal"; };


    @RequestMapping(value = "/eRSPG/chair/makeAnnouncement", method = RequestMethod.GET)
    public ModelAndView announcementForm() {
        return new ModelAndView("makeAnnouncement", "announcement", new AnnouncementForm());
    }


    // Creates new announcement
    @RequestMapping(value = "/eRSPG/chair/makeAnnouncement", method = RequestMethod.POST)
    public String saveAnnouncement(@Valid @ModelAttribute Announcement announcement,
                                   BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "error";
        }

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        announcement.setDate(df.format(date));

        model.addAttribute("title", announcement.getTitle());
        model.addAttribute("message", announcement.getMessage());
        model.addAttribute("date", announcement.getDate());
        announcementDao.addNewOrUpdateAnnouncement(announcement);

        return "announcementSuccess";
    }

    // Gets all users who are committee members
    // and maps them to JSON to /eRSPG/committeemembers
    @RequestMapping(value = "/eRSPG/committeemembers", method = RequestMethod.GET)
    public @ResponseBody List<CommitteeDTO> committeeList(
            @RequestParam(value = "roleType", defaultValue = "", required = false) String userRoleId) {
        Integer id = userRoleId == null || userRoleId.equals("") ? null : parseInt(userRoleId);
        List<UserRole> userRoles = id == null ?
                userRoleDAO.findUserRoleByRoleTypeId(2) :
                userRoleDAO.findUserRoleByRoleTypeId(2);

        return userRoles.stream()
                .map(p -> new
                            CommitteeDTO(p, userDAO.findUserById(p.getUserId())))
                .collect(Collectors.toList());
    }

    // Gets all proposals with proposalStatus = "Submitted"
    // and maps them to JSON to /eRSPG/submittedproposal
    @RequestMapping(value = "/eRSPG/submittedproposal", method = RequestMethod.GET)
    public @ResponseBody
    List<ProposalDTO> proposalListSubmitted(
            @RequestParam(value = "proposalStatus", defaultValue = "", required = false) String proposalStatusId) {
        Integer id = proposalStatusId == null || proposalStatusId.equals("") ? null : parseInt(proposalStatusId);
        List<Proposal> proposals = id == null ?
                proposalDao.findAllProposalByStatusId(2) :
                proposalDao.findAllProposalByStatusId(2);

        return proposals.stream()
                .map(p -> new
                        ProposalDTO(
                        p,
                        departmentDAO.findDepartment(p.getDepartmentId()),
                        userDAO.findUserById(p.getUserId()),
                        proposalStatusDAO.findProposalStatus(p.getProposalStatus())))
                .collect(Collectors.toList());
    }

    // Gets all proposals with proposalStatus = "In Review"
    // and maps them to JSON to /eRSPG/inreviewproposal
    @RequestMapping(value = "/eRSPG/inreviewproposal", method = RequestMethod.GET)
    public @ResponseBody
    List<ProposalDTO> proposalListInReview(@RequestParam(value = "proposalStatus", defaultValue = "", required = false) String proposalStatusId) {
        Integer id = proposalStatusId == null || proposalStatusId.equals("") ? null : parseInt(proposalStatusId);
        List<Proposal> proposals = id == null ?
                proposalDao.findAllProposalByStatusId(3) :
                proposalDao.findAllProposalByStatusId(3);

        return proposals.stream()
                .map(p -> new
                        ProposalDTO(
                        p,
                        departmentDAO.findDepartment(p.getDepartmentId()),
                        userDAO.findUserById(p.getUserId()),
                        proposalStatusDAO.findProposalStatus(p.getProposalStatus())))
                .collect(Collectors.toList());
    }

    // Assigns Submitted proposals to each committee member as a Reviewer object
    @RequestMapping(value = "/eRSPG/chair/assignproposal", method = RequestMethod.POST)
    public String assignProposalsToAll(@Valid @ModelAttribute Reviewer reviewer,
                                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "error";
        }


        // Find all proposals that have status "SUBMITTED"
        ArrayList<Proposal> proposalList = new ArrayList<Proposal>();
        proposalList.addAll(proposalDao.findAllProposalByStatusId(2));

        // Find all UserRoles who are Committee Members
        ArrayList<UserRole> userRoleList = new ArrayList<UserRole>();
        userRoleList.addAll(userRoleDAO.findUserRoleByRoleTypeId(2));

        // Loop through UserRoles and Submitted Proposals and add new Reviewer
        for (UserRole role : userRoleList) {
            for (Proposal proposal : proposalList) {
                Reviewer review = new Reviewer();
                review.setUserId(role.getUserId());
                review.setProposalId(proposal.getProposalId());
                review.setDepartmentId(1);
                review.setReviewComment("");
                review.setUpdatedAt(null);

                reviewerDAO.addReviewer(review);

                proposal.setProposalStatus(3);

                proposalDao.addNewOrUpdateProposal(proposal);
            }
        }
        return "assignProposal";
    }

    @RequestMapping(value = "/eRSPG/chair/manageBudget", method = RequestMethod.GET)
    public String manageBudget(Model model){
        ManageBudgetForm manageBudgetForm = new ManageBudgetForm();

        int year = Calendar.getInstance().get(Calendar.YEAR);
        BudgetAmount budget = budgetDAO.getBudgetForYear(year);

        double remainingBudget = 0;
        double totalBudget = 0;

        if(budget != null){
            remainingBudget = budget.getTotalFunds() - budget.getRemainingFunds();
            totalBudget = budget.getTotalFunds();
        }

        manageBudgetForm.setTotalBudget(totalBudget);
        manageBudgetForm.setRemainingBudget(remainingBudget);

        model.addAttribute("ManageBudgetForm", manageBudgetForm);
        model.addAttribute("totalBudget", manageBudgetForm.getTotalBudget());
        model.addAttribute("remainingBudget", manageBudgetForm.getRemainingBudget());


        return budgetDetails(model);
    }


    @RequestMapping(value = "/eRSPG/chair/budgetDetails", method = RequestMethod.GET)
    public String budgetDetails(Model model){
        ArrayList<BudgetDetails> budgetDetails = new ArrayList<BudgetDetails>();

        budgetDetails = budgetDAO.getBudgetDetails();

        model.addAttribute("BudgetDetails", budgetDetails);

        return "manageBudget";
    }

    // Changes Committee to Faculty UserRole
    @RequestMapping(value = "/eRSPG/chair/committee", method = RequestMethod.POST)
    public String changeCommitteeToFaculty(@RequestParam("userId") String userId) {

        UserRole user = userRoleDAO.findUserRoleById(parseInt(userId));
        user.setRoleTypeId(1);
        userRoleDAO.addNewOrUpdateUserRole(user);

        return "manageCommittee";
    }

    // Edit Committee Member info
    @RequestMapping(value = "/eRSPG/chair/editcommittee", method = RequestMethod.POST)
    public String editCommittee(@RequestParam("userRoleId") String userRoleId,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email) {

        UserRole userRole = userRoleDAO.findUserRoleById(Integer.parseInt(userRoleId));

        User user = userDAO.findUserById(userRole.getUserId());

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        userDAO.addNewOrUpdateUser(user);

        return "manageCommittee";
    }

    // Returns all faculty email and maps to JSON at 'eRSPG/emaillist'
    @RequestMapping(value = "/eRSPG/emaillist", method = RequestMethod.GET)
    public @ResponseBody
    List<EmailDTO> retrieveAllCommitteeEmail() {

        List<UserRole> userRoles = userRoleDAO.findUserRoleByRoleTypeId(1);
        List<String> emails = new ArrayList<String>();
        for (UserRole u : userRoles)
        {
            User user = userDAO.findUserById(u.getUserId());
            emails.add(user.getEmail().toString());
        }
        return emails.stream().map(p -> new EmailDTO(p))
                .collect(Collectors.toList());
    }

    // Searches for a faculty member by email, then sets that Users Role to Committee
    @RequestMapping(value = "/eRSPG/chair/addcommittee", method = RequestMethod.POST)
    public String addNewCommittee(@RequestParam("fEmail") String email) {

        User facultyMember = userDAO.findUserByEmail(email);
        UserRole newCommittee = userRoleDAO.findUserRoleById(facultyMember.getUserId());
        newCommittee.setRoleTypeId(2);
        userRoleDAO.addNewOrUpdateUserRole(newCommittee);

        return "manageCommittee";
    }

    @RequestMapping(value = "/eRSPG/chair/addnewuser")
    public String addNewUser(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email) {

        User newUser = new User(email, firstName, lastName);
        userDAO.addNewOrUpdateUser(newUser);

        User user = userDAO.findUserByEmail(email);

        UserRole userRole = new UserRole(user.getUserId(), 2, null, null);

        userRoleDAO.addNewOrUpdateUserRole(userRole);

        return "manageCommittee";
    }
}