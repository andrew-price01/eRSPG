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
}
