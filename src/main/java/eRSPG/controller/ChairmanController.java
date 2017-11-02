package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ChairmanController {

	@RequestMapping("/chairman/userManagement")
	public String userManagement(Model model) {
		String contentPage = "userManagement.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}

	@RequestMapping("/chairman/changeChairman")
	public String changeChairman(Model model) {
		String contentPage = "changeChairman.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}

	@RequestMapping("/chairman/createAnnouncement")
	public String createAnnouncement(Model model) {
		String contentPage = "createAnnouncement.jsp";
		model.addAttribute("contentPage", contentPage);
		return "projectIndex";
	}
}

