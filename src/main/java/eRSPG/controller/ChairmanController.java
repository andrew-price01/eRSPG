package eRSPG.controller;

import eRSPG.Repository.*;
import eRSPG.model.*;
import eRSPG.model.form.AnnouncementForm;
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
@SessionAttributes("AnnouncementForm")
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

    @RequestMapping("/eRSPG/chairman/home")
    public String chairmanHome() {
        return "chairmanHome";
    }

    @RequestMapping("/eRSPG/chairman/makeAnnouncement")
    public String makeAnnouncement() {
        return "makeAnnouncement";
    }

    @RequestMapping("/eRSPG/chairman/proposal")
    public String chairmanProposal() {
        return "chairmanProposalHome";
    }

    @RequestMapping("/eRSPG/chairman/committee")
    public String chairmanCommittee() {
        return "manageCommittee";
    }

    @RequestMapping("/eRSPG/chairman/assignproposal")
    public String chairmanAssignProposal() {
        return "assignProposal";
    }

    @RequestMapping("/eRSPG/chairman/announcementSuccess")
    public String chairmanAnnouncmentSuccess() { return "announcementSuccess"; };


    @RequestMapping(value = "/eRSPG/chairman/makeAnnouncement", method = RequestMethod.GET)
    public ModelAndView announcementForm() {
        return new ModelAndView("makeAnnouncement", "announcement", new AnnouncementForm());
    }


    // Creates new announcement
    @RequestMapping(value = "/eRSPG/chairman/makeAnnouncement", method = RequestMethod.POST)
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
    @RequestMapping(value = "/eRSPG/chairman/assignproposal", method = RequestMethod.POST)
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

    // Changes Committee to Faculty UserRole
    @RequestMapping(value = "/eRSPG/chairman/committee", method = RequestMethod.POST)
    public String changeCommitteeToFaculty(@RequestParam("userId") String userId) {

        UserRole user = userRoleDAO.findUserRoleById(parseInt(userId));
        user.setRoleTypeId(1);
        userRoleDAO.addNewOrUpdateUserRole(user);

        return "manageCommittee";
    }

    // Edit Committee Member info
    @RequestMapping(value = "/eRSPG/chairman/editcommittee", method = RequestMethod.POST)
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
}