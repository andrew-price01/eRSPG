package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProposalController {
	@RequestMapping("/proposal/index")
	public String startForm(){
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/budget")
	public String budgetForm(){
		return "proposalBudget";
	}
	
	@RequestMapping("/proposal/detail")
	public String proposalForm(){
		return "proposalDetail";
	}
	
	@RequestMapping("/proposal/body")
	public String bodyForm(){
		return "proposalBody";
	}
	
	@RequestMapping("/proposal/upload")
	public String uploadForm(){
		return "proposalUpload";
	}
	
	@RequestMapping("/proposal/review")
	public String reviewForm(){
		return "proposalReview";
	}
	
}
