package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewerController {

	@RequestMapping("/reviewer/announcements")
	public String announcements(Model model) {
		String contentPage = "announcements.jsp";
		model.addAttribute("contentPage", contentPage);
		return "projectIndex";
	}

	@RequestMapping("/reviewer/proposalList")
	public String proposalList(Model model) {
		String contentPage = "proposalList.jsp";
		model.addAttribute("contentPage", contentPage);
		return "projectIndex";
	}

	@RequestMapping("/reviewer/reviewProposal")
	public String review(Model model) {
		String contentPage = "review.jsp";
		model.addAttribute("contentPage", contentPage);
		return "projectIndex";
	}
}
