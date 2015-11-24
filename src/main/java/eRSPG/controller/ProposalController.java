package eRSPG.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import eRSPG.model.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import eRSPG.Repository.ProposalDAO;
import eRSPG.model.Proposal;
import eRSPG.model.form.AwardTypeForm;
import eRSPG.model.form.BudgetForm;
import eRSPG.model.form.DetailForm;
import eRSPG.model.form.UploadForm;
import eRSPG.model.form.BodyForm;

@Controller
@SessionAttributes({"detailForm","awardTypeForm","uploadForm","budgetForm","bodyForm","bodyDetailsForm","bodyQuestionsForm"})
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
		UploadForm uploadForm = new UploadForm();
		BudgetForm budgetForm = new BudgetForm();
		BodyForm bodyForm = new BodyForm();
		BodyDetailsForm bodyDetailsForm = new BodyDetailsForm();
		BodyQuestionsForm bodyQuestionsForm = new BodyQuestionsForm();

		//model.addAttribute("submission", savedSubmission);
		model.addAttribute("detailForm", detailForm);
		model.addAttribute("awardTypeForm",awardForm);
		model.addAttribute("uploadForm", uploadForm);
		model.addAttribute("budgetForm", budgetForm);
		model.addAttribute("bodyForm", bodyForm);
        model.addAttribute("bodyDetailsForm", bodyDetailsForm);
        model.addAttribute("bodyQuestionsForm", bodyQuestionsForm);

		return "redirect:/proposal/detail";
	}

	@RequestMapping(value="/proposal/budget", method=RequestMethod.GET)
	public String budgetForm(Model model){
		String contentPage = "budget.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/budget", method=RequestMethod.POST)
	public String saveProposalBudget(@ModelAttribute @Valid BudgetForm detailForm, BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "budget.jsp");
			return "projectIndex";
		}

		return "redirect:/proposal/body";
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

	@RequestMapping(value="/proposal/body", method=RequestMethod.GET)
	public String bodyForm(Model model){
		String contentPage = "proposalBody.jsp";
		model.addAttribute("contentPage", contentPage);
		return "projectIndex";
	}

	@RequestMapping(value="/proposal/body", method=RequestMethod.POST)
	public String saveBodyForm(@ModelAttribute @Valid BodyForm bodyForm, BindingResult result, Model model)
	{
		System.out.println(result.hasErrors());
        System.out.println(result);
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalBody.jsp");
			return "projectIndex";
		}

		return "redirect:/proposal/bodyDetails";
	}

    @RequestMapping(value="/proposal/bodyDetails", method=RequestMethod.GET)
    public String bodyDetailsForm(Model model){
        String contentPage = "proposalBodyDetails.jsp";
        model.addAttribute("contentPage", contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/proposal/bodyDetails", method=RequestMethod.POST)
    public String saveBodyDetailsForm(@ModelAttribute @Valid BodyDetailsForm bodyDetailsForm, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBodyDetails.jsp");
            return "projectIndex";
        }

        return "redirect:/proposal/bodyQuestions";
    }

    @RequestMapping(value="/proposal/bodyQuestions", method=RequestMethod.GET)
    public String bodyQuestionsForm(Model model){
        String contentPage = "proposalBodyQuestions.jsp";
        model.addAttribute("contentPage", contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/proposal/bodyQuestions", method=RequestMethod.POST)
    public String saveBodyQuestionsForm(@ModelAttribute @Valid BodyQuestionsForm bodyQuestionsForm, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBodyQuestions.jsp");
            return "projectIndex";
        }

        return "redirect:/proposal/upload";
    }
	
	@RequestMapping(value="/proposal/upload", method=RequestMethod.GET)
	public String uploadForm(Model model){
		String contentPage = "proposalUpload.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("fileUpload") MultipartFile file, @ModelAttribute("uploadForm") UploadForm uploadForm
		, Model model){
		String name="1234";
		if (!file.isEmpty()) {
        	try {
                byte[] bytes = file.getBytes();
               
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                uploadForm.setFileUpload(file);
                uploadForm.setName(name);
               
                return "redirect:/proposal/finish";
            } catch (Exception e) {
            	
            	model.addAttribute("failedUpload","failed to upload file!");
            	model.addAttribute("contentPage","proposalUpload.jsp");
                return "projectIndex";
                
            }
        } else {
        	model.addAttribute("failedUpload","failed to upload file!");
        	model.addAttribute("contentPage","proposalUpload.jsp");
            return "projectIndex";
        }
		//return "projectIndex";
	}
	
	@RequestMapping("/proposal/review")
	public String reviewForm(Model model){
		String contentPage = "proposalReview.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	
	@RequestMapping("/proposal/submit")
	public void submit(@ModelAttribute("detailForm") DetailForm detailForm,
						@ModelAttribute("awardTypeForm") AwardTypeForm awardForm,
						@ModelAttribute("bodyForm") BodyForm bodyForm,
						@ModelAttribute("budgetForm") BudgetForm budgetForm)
	{
		
		processSubmission(detailForm, awardForm, bodyForm, budgetForm);
		
		
	}
	private void processSubmission( DetailForm detailForm,
					AwardTypeForm awardForm,
					BodyForm bodyForm,
					BudgetForm budgetForm)
	{
	
		Proposal proposal = new Proposal();
		proposal.setProjectDirector(detailForm.getProjectDirector());
		proposal.setProposalComplete(true);
		proposal.setProposalMailCode(detailForm.getProposalMailCode());
		proposal.setProposalExtension(detailForm.getProposalExtension());
		proposal.setProposalEmail(detailForm.getProposalEmail());
		proposal.setProposalReqStdAsst(budgetForm.getStudentAssistants());
		proposal.setProposalTitle(detailForm.getProposalTitle());
		
		//TODO: get budgetForm data and save to database
		
		
		//TODO: save uploaded files to server
		
	}
	
	
}
