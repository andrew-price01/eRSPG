package eRSPG.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import eRSPG.Repository.ProposalDAO;
import eRSPG.model.form.AwardTypeForm;
import eRSPG.model.form.DetailForm;

@Controller
@SessionAttributes({"detailForm","awardTypeForm"})
public class ProposalController {
	
	@Autowired
	private ProposalDAO proposalDao;
	
	@RequestMapping("/proposal/index")
	public String startForm(Model model){
		String contentPage = "proposalStart.jsp";
		model.addAttribute("contentPage",contentPage);
		
		
		return "projectIndex";
	}
	
	@RequestMapping("/proposal/start")
	public String startSubmission(Model model)
	{
		
		//ProposalSubmission savedSubmission = new ProposalSubmission();
		//proposal.setProposalTitle("Testing");
			
		DetailForm detailForm = new DetailForm();
		AwardTypeForm awardForm = new AwardTypeForm();
		
		
		
		//model.addAttribute("submission", savedSubmission);
		model.addAttribute("detailForm", detailForm);
		model.addAttribute("awardTypeForm",awardForm);
		
		
		return "redirect:/proposal/detail";
	}
	
	@RequestMapping("/proposal/budget")
	public String budgetForm(Model model){
		String contentPage = "budget.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/detail", method=RequestMethod.GET)
	public String proposalForm(Model model){
		
		String contentPage = "proposalDetail.jsp";
		model.addAttribute("contentPage",contentPage);
		//Proposal proposal = new Proposal();
		//model.addAttribute("proposal",proposal);
		
		return "projectIndex";
	}
	
	
	@RequestMapping(value="/proposal/detail", method=RequestMethod.POST)
	public String saveProposalDetail(@ModelAttribute @Valid DetailForm detailForm, BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalDetail.jsp");
			return "projectIndex";
		}

		return "redirect:/proposal/detail/awardType";
	}
	
	@RequestMapping(value="/proposal/detail/awardType", method=RequestMethod.GET)
	public String awardTypeForm( Model model){
		
		String contentPage = "proposalRewardType.jsp";
		model.addAttribute("contentPage",contentPage);
		
		
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/detail/awardType", method=RequestMethod.POST)
	public String saveAwardType(@ModelAttribute @Valid AwardTypeForm awardForm, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalRewardType.jsp");
			return "projectIndex";
		}
		return "redirect:/proposal/budget";
	}
	
	
	@RequestMapping("/proposal/body")
	public String bodyForm(Model model){
		String contentPage = "proposalBody.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/upload", method=RequestMethod.GET)
	public String uploadForm(Model model){
		String contentPage = "proposalUpload.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/upload", method=RequestMethod.POST)
	public String upload(Model model){
		return "projectIndex";
	}
	
	
	@RequestMapping("/proposal/review")
	public String reviewForm(Model model){
		String contentPage = "proposalReview.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
}
