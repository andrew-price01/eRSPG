package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProposalController {
	@RequestMapping("/proposal/index")
	public String startForm(Model model){
		String contentPage = "proposalStart.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/budget")
	public String budgetForm(Model model){
		String contentPage = "budget.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/detail")
	public String proposalForm(Model model){
		
		String contentPage = "proposalDetail.jsp";
		model.addAttribute("contentPage",contentPage);
		
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/body")
	public String bodyForm(Model model){
		String contentPage = "proposalBody.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/upload")
	public String uploadForm(Model model){
		String contentPage = "proposalUpload.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/review")
	public String reviewForm(Model model){
		String contentPage = "proposalReview.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
}
