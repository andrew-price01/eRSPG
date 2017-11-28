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
        public String chairmanHome(){
        return "chairmanHome";
    }

        @RequestMapping("/eRSPG/chairman/makeAnnouncement")
        public String makeAnnouncement()
        {
            return "makeAnnouncement";
        }

        @RequestMapping("/eRSPG/chairman/proposal")
        public String chairmanProposal() { return "chairmanProposalHome"; }

        @RequestMapping("/eRSPG/chairman/committee")
        public String chairmanCommittee() { return "manageCommittee"; }

        @RequestMapping("/eRSPG/chairman/assignproposal")
        public String chairmanAssignProposal() {return "assignProposal"; }

    @RequestMapping(value = "/eRSPG/chairman/makeAnnouncement", method = RequestMethod.GET)
    public ModelAndView announcementForm() {
        return new ModelAndView("makeAnnouncement", "announcement", new AnnouncementForm());
    }

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

/*
    @RequestMapping(value = "/eRSPG/chairman/assignproposal", method = RequestMethod.GET)
    public ModelAndView listProposals() {
        ArrayList<Proposal> model = new ArrayList<Proposal>();
            model.addAll(proposalDao.findAllProposals());
            return new ModelAndView("assignProposal", "proposal", model);
    }
*/

    @RequestMapping(value = "/eRSPG/submittedproposal", method = RequestMethod.GET)
    public @ResponseBody List<ProposalDTO> proposalListSubmitted(
            @RequestParam(value = "proposalStatus", defaultValue = "", required = false) String proposalStatusId) {
        Integer id = proposalStatusId == null || proposalStatusId.equals("") ? null : Integer.parseInt(proposalStatusId);
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

    @RequestMapping(value = "/eRSPG/inreviewproposal", method = RequestMethod.GET)
    public @ResponseBody List<ProposalDTO> proposalListInReview(
            @RequestParam(value = "proposalStatus", defaultValue = "", required = false) String proposalStatusId) {
        Integer id = proposalStatusId == null || proposalStatusId.equals("") ? null : Integer.parseInt(proposalStatusId);
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

/*    @RequestMapping(value = "/eRSPG/chairman/assignproposal", method = RequestMethod.GET)
    public ModelAndView assignProposal() {
        return new ModelAndView("assignProposal", "proposal", null);
    }*/

    @RequestMapping(value = "/eRSPG/chairman/assignproposal", method = RequestMethod.POST)
    public String assignProposalsToAll(@Valid @ModelAttribute Reviewer reviewer,
                                   BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "error";
        }


        // Find all proposals that have status "SUBMITTED"
        ArrayList<Proposal> proposalList = new ArrayList<Proposal>();
        proposalList.addAll(proposalDao.findAllProposalByStatusId(2));

        ArrayList<UserRole> userRoleList = new ArrayList<UserRole>();
        userRoleList.addAll(userRoleDAO.findAllUserRole());

        for(UserRole role : userRoleList) {
            for(Proposal proposal : proposalList) {
//                Reviewer review = new Reviewer();
                reviewer.setUserId(role.getUserId());
                reviewer.setProposalId(proposal.getProposalId());
                reviewer.setDepartmentId(1);
                reviewer.setReviewComment("");
                reviewer.setUpdatedAt(null);

                reviewerDAO.addReviewer(reviewer);

                proposal.setProposalStatus(3);

                proposalDao.addNewOrUpdateProposal(proposal);
            }
        }
        return "assignProposal";
    }

}