package eRSPG.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import eRSPG.Repository.DepartmentDAO;
import eRSPG.Repository.EssayAnswerDAO;
import eRSPG.Repository.FileUploadDAO;
import eRSPG.Repository.FundDAO;
import eRSPG.Repository.ProposalDAO;
import eRSPG.Repository.RequestAwardDAO;
import eRSPG.Repository.SemesterDAO;
import eRSPG.model.Department;
import eRSPG.model.EssayAnswer;
import eRSPG.model.Fund;
import eRSPG.model.Proposal;
import eRSPG.model.RequestAward;
import eRSPG.model.Semester;
import eRSPG.model.UploadFile;
import eRSPG.model.form.AwardTypeForm;
import eRSPG.model.form.BodyDetailsForm;
import eRSPG.model.form.BodyForm;
import eRSPG.model.form.BodyQuestionsForm;
import eRSPG.model.form.BudgetForm;
import eRSPG.model.form.DepartmentForm;
import eRSPG.model.form.DetailForm;
import eRSPG.model.form.UploadForm;

@Controller
@SessionAttributes({"departmentForm","detailForm","awardTypeForm","uploadForm","budgetForm","bodyForm","bodyDetailsForm","bodyQuestionsForm"})
public class ProposalController {
	
	@Autowired
	private ProposalDAO proposalDao;
	
	@Autowired
	private RequestAwardDAO requestAwardDao;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private SemesterDAO semesterDAO;
	
	@Autowired
	private FundDAO fundDAO;
	
	@Autowired
	private EssayAnswerDAO essayAnswerDAO;
	
	@Autowired
	private FileUploadDAO fileUploadDAO;
	
	final String uploadDirectory = "C:/eRSPG/fileAttachments/";
	
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
		
		DepartmentForm deptForm = new DepartmentForm();
		DetailForm detailForm = new DetailForm();
		AwardTypeForm awardForm = new AwardTypeForm();
		UploadForm uploadForm = new UploadForm();
		BudgetForm budgetForm = new BudgetForm();
		BodyForm bodyForm = new BodyForm();
		BodyDetailsForm bodyDetailsForm = new BodyDetailsForm();
		BodyQuestionsForm bodyQuestionsForm = new BodyQuestionsForm();

		//model.addAttribute("submission", savedSubmission);
		model.addAttribute("departmentForm", deptForm);
		model.addAttribute("detailForm", detailForm);
		model.addAttribute("awardTypeForm",awardForm);
		model.addAttribute("uploadForm", uploadForm);
		model.addAttribute("budgetForm", budgetForm);
		model.addAttribute("bodyForm", bodyForm);
        model.addAttribute("bodyDetailsForm", bodyDetailsForm);
        model.addAttribute("bodyQuestionsForm", bodyQuestionsForm);

		return "redirect:/proposal/department";
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
	
	@RequestMapping(value="/proposal/department", method=RequestMethod.GET)
	public String departmentForm(Model model)
	{
		String contentPage = "proposalDepartment.jsp";
		model.addAttribute("contentPage",contentPage );
		
		Map<Integer, String> departmentList = new HashMap<>();
		Map<Integer, String> semesterList = new HashMap<>();
		
		
		model.addAttribute("deptList",departmentList);
		model.addAttribute("semesterList",semesterList);
		
		List<Department> deptDBList = departmentDAO.findAllDepartment();
		
		for (Department department : deptDBList) {
			
			departmentList.put(department.getDepartmentId(), department.getDepartmentName());
		}
		
		List<Semester> semesterDBList = semesterDAO.findAllSemester();
		
		for (Semester semester : semesterDBList) {
			semesterList.put(semester.getSemesterId(), semester.getSemesterName());
		}
		
		
		
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/department", method=RequestMethod.POST)
	public String saveDepartmentForm(@ModelAttribute @Valid DepartmentForm deptForm, BindingResult result,Model model)
	{
		//String contentPage = "proposalDepartment.jsp";
		//model.addAttribute("contentPage",contentPage );
		
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalDepartment.jsp");
			return "projectIndex";
		}
		
		return "redirect:/proposal/detail";
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
               
               /* BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                uploadForm.setFileUpload(file);
                */
                uploadForm.setName(file.getOriginalFilename());
                
                uploadForm.setBytes(bytes);
               
                return "redirect:/proposal/submit";
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
	public @ResponseBody String submit(@ModelAttribute("detailForm") DetailForm detailForm,
						@ModelAttribute("awardTypeForm") AwardTypeForm awardForm,
						@ModelAttribute("bodyForm") BodyForm bodyForm,
						@ModelAttribute("budgetForm") BudgetForm budgetForm,
						@ModelAttribute("departmentForm") DepartmentForm deptForm,
						@ModelAttribute("bodyQuestionsForm") BodyQuestionsForm bodyQuestForm,
						@ModelAttribute("bodyDetailsForm") BodyDetailsForm bodyDetailsForm,
						@ModelAttribute("uploadForm") UploadForm uploadForm)
	{
		
		processSubmission(detailForm, awardForm, bodyForm, budgetForm,deptForm, bodyQuestForm, bodyDetailsForm
							,uploadForm);
		return "Successfully Submitted";
		
		
	}
	private void processSubmission( DetailForm detailForm,
					AwardTypeForm awardForm,
					BodyForm bodyForm,
					BudgetForm budgetForm,
					DepartmentForm deptForm,
					BodyQuestionsForm bodyQuestForm,
					BodyDetailsForm bodyDetailsForm,
					UploadForm uploadForm)
	{
	
		LocalDateTime time = LocalDateTime.now();
		
	    
	    
		Proposal proposal = new Proposal();
		proposal.setProjectDirector(detailForm.getProjectDirector());
		proposal.setProposalComplete(true);
		proposal.setProposalMailCode(detailForm.getProposalMailCode());
		proposal.setProposalExtension(detailForm.getProposalExtension());
		proposal.setProposalEmail(detailForm.getProposalEmail());
		proposal.setProposalReqStdAsst(budgetForm.getStudentAssistants());
		proposal.setProposalTitle(detailForm.getProposalTitle());
		proposal.setSemesterId(deptForm.getSemesterID());
		proposal.setProjectTypeId(awardForm.getProjectTypeID());
		proposal.setDepartmentId(deptForm.getDepartmentID());
		proposal.setProposalYear(deptForm.getYear());
		proposal.setSubmissionDate(time);
		proposal.setUpdatedDate(time);
		
		
		
		
		proposalDao.addNewOrUpdateProposal(proposal);
		
		int proposalID = proposal.getProposalId();
		
		//List<RequestAward> requestAwardList = new ArrayList<>();
		
		for(int i = 0; i < awardForm.getAwardTypes().size(); i++)
		{
			RequestAward requestAward = new RequestAward();
			requestAward.setProposalId(proposalID);
			requestAward.setAwardTypeId(awardForm.getAwardTypes().get(i));
			
			requestAwardDao.addNewOrUpdateRequestAward(requestAward);
			
		}
		

		
		List<Fund> fundList = budgetForm.generateFundObjects();
		
		// iterate through the all fund objects and set the proposal id
		for (Fund fund : fundList) {
			fund.setProposalId(proposalID);
			fundDAO.addNewOrUpdateFund(fund);
		}
		
		// save essay question answers
		List<EssayAnswer> answerList = bodyForm.generateEssayAnswers();
		
		List<EssayAnswer> bodyQuestionsAnswers = bodyQuestForm.generateEssayAnswers();
		
		List<EssayAnswer> bodyDetailAnswers = bodyDetailsForm.generateEssayAnswers();
		
		answerList.addAll(bodyQuestionsAnswers);
		answerList.addAll(bodyDetailAnswers);
		
		for (EssayAnswer essayAnswer : answerList) {
			
			essayAnswer.setProposalId(proposalID);
			essayAnswer.setUpdatedDate(time);
			essayAnswerDAO.addNewOrUpdateEssayAnswer(essayAnswer);
		}
		
		//TODO: save uploaded files to server
		
		String fileName = proposalID + "_" + uploadForm.getFileUpload().getOriginalFilename();
		
		File file = new File(this.uploadDirectory + fileName);
		
		if(file.exists())
		{
			file.delete();
			
		}
		try
		{
			file.createNewFile();
			OutputStream output = new FileOutputStream(file);
			output.write(uploadForm.getBytes());
			output.close();
			
			List<UploadFile> uploadFiles = uploadForm.generateUploadFiles();
			
			for (UploadFile uploadFile : uploadFiles) {
				uploadFile.setProposalId(proposalID);
				uploadFile.setPath(this.uploadDirectory + fileName);
				uploadFile.setFileName(uploadForm.getName());
				
				fileUploadDAO.save(uploadFile);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		//TODO: clear session form data
		
	}
	
	
}
