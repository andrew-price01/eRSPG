package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ChairmanController {

	@RequestMapping("eRSPG/chairman/userManagement")
	public String userManagement(Model model) {

		String contentPage = "userManagement.jsp";
		model.addAttribute("contentPage",contentPage);
		return "userManagement";
	}

	@RequestMapping("eRSPG/chairman/changeChairman")
	public String changeChairman(Model model) {
		String contentPage = "changeChairman.jsp";
		model.addAttribute("contentPage",contentPage);
		return "changeChairman";
	}
}

