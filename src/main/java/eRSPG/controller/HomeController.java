package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("admin/home")
	public String adminHome(){
		return "adminHome";
	}

	@RequestMapping("committee/home")
	public String committeeHome(){
		return "committeeHome";
	}

}
