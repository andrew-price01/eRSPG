package eRSPG.controller;

import eRSPG.Repository.*;
import eRSPG.model.*;
import eRSPG.model.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"departmentForm","detailForm","awardTypeForm","uploadForm","budgetForm","bodyForm","bodyDetailsForm","bodyQuestionsForm", "userForm"})
public class ProposalController {
	
	/**
	 * Dependency injection for data access objects.
	 * 
	 */
	
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

	@Autowired
	private UserDAO userDAO;
	
	final String uploadDirectory = "C:/eRSPG/fileAttachments/"; //directory that store file attachments
	
	public String getNextPage(@RequestParam("nextPage") String nextPage) {
		return nextPage;
	}


	@RequestMapping(value = "/proposal", method = RequestMethod.GET)
	public @ResponseBody List<Proposal> proposalListByUserId(
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		if (userId == null) {
			userId = "";
		}
		return userId.isEmpty() ?
				proposalDao.findAllProposals() :
				proposalDao.findProposalByUserId(userId);
	}

	@RequestMapping(value = "/proposal/list", method = RequestMethod.GET)
	public String proposalList(
	        @RequestParam(value = "userId", defaultValue = "", required = false) String userId,
            Model model) {

		model.addAttribute("proposalList", proposalListByUserId(userId));
        return "proposalList";
	}

	@RequestMapping("/proposal/start")
	public String startSubmission(Model model)
	{
		
		
		DepartmentForm deptForm = new DepartmentForm();
		DetailForm detailForm = new DetailForm();
		AwardTypeForm awardForm = new AwardTypeForm();
		UploadForm uploadForm = new UploadForm();
		BudgetForm budgetForm = new BudgetForm();
		BodyForm bodyForm = new BodyForm();
		BodyDetailsForm bodyDetailsForm = new BodyDetailsForm();
		BodyQuestionsForm bodyQuestionsForm = new BodyQuestionsForm();
		UserForm userForm = new UserForm();

		/*
		 * Add all the form objects to the session
		 */
		model.addAttribute("departmentForm", deptForm);
		model.addAttribute("detailForm", detailForm);
		model.addAttribute("awardTypeForm",awardForm);
		model.addAttribute("uploadForm", uploadForm);
		model.addAttribute("budgetForm", budgetForm);
		model.addAttribute("bodyForm", bodyForm);
        model.addAttribute("bodyDetailsForm", bodyDetailsForm);
        model.addAttribute("bodyQuestionsForm", bodyQuestionsForm);
		model.addAttribute("userForm", userForm);

		return "redirect:/proposal/detail";
	}

	@RequestMapping(value="/proposal/index", method=RequestMethod.GET)
	public String UserForm(Model model){
		String contentPage = "proposalStart.jsp";
		model.addAttribute("contentPage",contentPage);

		return "projectIndex";
	}

	@RequestMapping(value="/proposal/index", method=RequestMethod.POST)
	public String saveUserForm(@ModelAttribute @Valid UserForm userForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
	{
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalBudget.jsp");
			return "projectIndex";
		}

		//return "redirect:/proposal/body";
		return "redirect:/" + nextPage;
	}

	@RequestMapping(value="/proposal/budget", method=RequestMethod.GET)
	public String budgetForm(Model model){
		String contentPage = "proposalBudget.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/budget", method=RequestMethod.POST)
	public String saveProposalBudget(@ModelAttribute @Valid BudgetForm detailForm, BindingResult result,Model model, @RequestParam("nextPage") String nextPage)
	{
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalBudget.jsp");
			return "projectIndex";
		}

		//return "redirect:/proposal/body";
		return "redirect:/" + nextPage;
	}
	
	@RequestMapping(value="/proposal/department", method=RequestMethod.GET)
	public String departmentForm(Model model)
	{
		String contentPage = "proposalDepartment.jsp";
		model.addAttribute("contentPage",contentPage );
		
		Map<Integer, String> departmentList = new HashMap<>();
		Map<Integer, String> semesterList = new HashMap<>();
		
		//retrieve list of departments from database and store in model for access
		// in view.
		
		model.addAttribute("deptList",departmentList);
		model.addAttribute("semesterList",semesterList);
		
		List<Department> deptDBList = departmentDAO.findAllDepartment();
		
		for (Department department : deptDBList) {
			
			departmentList.put(department.getDepartmentId(), department.getDepartmentName());
		}
		
		// retrieve list of semester from database and store in model for access
		// in view.
		
		List<Semester> semesterDBList = semesterDAO.findAllSemester();
		
		for (Semester semester : semesterDBList) {
			semesterList.put(semester.getSemesterId(), semester.getSemesterName());
		}
		
		
		
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/department", method=RequestMethod.POST)
	public String saveDepartmentForm(@ModelAttribute @Valid DepartmentForm deptForm, BindingResult result,Model model, @RequestParam("nextPage") String nextPage)
	{
		//String contentPage = "proposalDepartment.jsp";
		//model.addAttribute("contentPage",contentPage );
		
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalDepartment.jsp");
			return "projectIndex";
		}
		
		System.out.println(nextPage);

		//return "redirect:/proposal/detail";
		//return "redirect:/proposal/awardType";
		return "redirect:/" + nextPage;
	}
	
	
	
	@RequestMapping(value="/proposal/detail", method=RequestMethod.GET)
	public String proposalForm(Model model){
		
		String contentPage = "proposalDetail.jsp";
		model.addAttribute("contentPage",contentPage);
		
		
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/detail", method=RequestMethod.POST)
	public String saveProposalDetail(@ModelAttribute @Valid DetailForm detailForm, BindingResult result,Model model, @RequestParam("nextPage") String nextPage)
	{
		if(result.hasErrors())
		{
			model.addAttribute("contentPage", "proposalDetail.jsp");
			return "projectIndex";
		}

		//return "redirect:/proposal/awardType";
		return "redirect:/" + nextPage;
	}
	
	@RequestMapping(value="/proposal/awardType", method=RequestMethod.GET)
	public String awardTypeForm(@ModelAttribute("departmentForm") DepartmentForm deptForm,@ModelAttribute("awardTypeForm") AwardTypeForm awardForm, Model model){
		
		String semester = "Spring";
		if(deptForm.getSemesterID() == 1)
		{
			semester = "Spring";
		}
		else if(deptForm.getSemesterID() == 2)
		{
			semester = "Fall";
			
		}
		else if(deptForm.getSemesterID() == 3)
		{
			semester = "Summer";
		}
		
		model.addAttribute("semester",semester);
		
		String contentPage = "proposalAwardType.jsp";
		model.addAttribute("contentPage",contentPage);

		
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/awardType", method=RequestMethod.POST)
	public String saveAwardType(@ModelAttribute("departmentForm") DepartmentForm deptForm,@ModelAttribute @Valid AwardTypeForm awardForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
	{
		if(result.hasErrors())
		{
			String semester = "Spring";
			if(deptForm.getSemesterID() == 1)
			{
				semester = "Spring";
			}
			else if(deptForm.getSemesterID() == 2)
			{
				semester = "Fall";
				
			}
			else if(deptForm.getSemesterID() == 3)
			{
				semester = "Summer";
			}
			
			model.addAttribute("semester",semester);
			
			model.addAttribute("contentPage", "proposalAwardType.jsp");
			return "projectIndex";
		}
		//return "redirect:/proposal/budget";
		return "redirect:/" + nextPage;
	}

	@RequestMapping(value="/proposal/body", method=RequestMethod.GET)
	public String bodyForm(@ModelAttribute AwardTypeForm awardForm,Model model){
		
		boolean collaborative = false;
		boolean excellence = false;

		// TODO: Null pointer
		if(awardForm.getAwardTypes() != null && awardForm.getAwardTypes().contains(6)){
			collaborative = true;
		}
		if(awardForm.getAwardTypes() != null && awardForm.getAwardTypes().contains(5))
		{
			excellence = true;
		}

		model.addAttribute("excellence", excellence);
		model.addAttribute("collaborative",collaborative);
		
		String contentPage = "proposalBody.jsp";
		model.addAttribute("contentPage", contentPage);
		return "projectIndex";
	}

	@RequestMapping(value="/proposal/body", method=RequestMethod.POST)
	public String saveBodyForm(@ModelAttribute AwardTypeForm awardForm,@ModelAttribute @Valid BodyForm bodyForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
	{
		//System.out.println(result.hasErrors());
       // System.out.println(result);
		
		
		
		if(result.hasErrors())
		{
			boolean collaborative = false;
			boolean excellence = false;
			
			if(awardForm.getAwardTypes().contains(6)){
				collaborative = true;
			}
			if(awardForm.getAwardTypes().contains(5))
			{
				excellence = true;
			}
			model.addAttribute("excellence", excellence);
			model.addAttribute("collaborative",collaborative);
			
			model.addAttribute("contentPage", "proposalBody.jsp");
			return "projectIndex";
		}

		//return "redirect:/proposal/bodyDetails";
		return "redirect:/" + nextPage;
	}

    @RequestMapping(value="/proposal/bodyDetails", method=RequestMethod.GET)
    public String bodyDetailsForm(Model model){
        String contentPage = "proposalBodyDetails.jsp";
        model.addAttribute("contentPage", contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/proposal/bodyDetails", method=RequestMethod.POST)
    public String saveBodyDetailsForm(@ModelAttribute @Valid BodyDetailsForm bodyDetailsForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBodyDetails.jsp");
            return "projectIndex";
        }

        //return "redirect:/proposal/bodyQuestions";
		return "redirect:/" + nextPage;
    }

    @RequestMapping(value="/proposal/bodyQuestions", method=RequestMethod.GET)
    public String bodyQuestionsForm(Model model){
        String contentPage = "proposalBodyQuestions.jsp";
        model.addAttribute("contentPage", contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/proposal/bodyQuestions", method=RequestMethod.POST)
    public String saveBodyQuestionsForm(@ModelAttribute @Valid BodyQuestionsForm bodyQuestionsForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBodyQuestions.jsp");
            return "projectIndex";
        }

        //return "redirect:/proposal/upload";
		return "redirect:/" + nextPage;
    }
	
	@RequestMapping(value="/proposal/upload", method=RequestMethod.GET)
	public String uploadForm(Model model){
		String contentPage = "proposalUpload.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("fileUpload") MultipartFile file, @ModelAttribute("uploadForm") UploadForm uploadForm
		, Model model, @RequestParam("nextPage") String nextPage){
		
		if (!file.isEmpty()) {
        	try {
                byte[] bytes = file.getBytes();
               
               
                uploadForm.setName(file.getOriginalFilename());
                
                uploadForm.setBytes(bytes);

                //return "redirect:/proposal/review";
                //return "redirect:/proposal/submit";
        		return "redirect:/" + nextPage;
            } catch (Exception e) {
            	
            	model.addAttribute("failedUpload","failed to upload file!");
            	model.addAttribute("contentPage","proposalUpload.jsp");
        		return "redirect:/" + nextPage;
                //return "projectIndex";
                
            }
        } 
		else {
        	model.addAttribute("failedUpload","failed to upload file!");
        	model.addAttribute("contentPage","proposalUpload.jsp");
            //return "projectIndex";
        	return "redirect:/" + nextPage;
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
						@ModelAttribute("userForm") UserForm userForm,
						@ModelAttribute("uploadForm") UploadForm uploadForm)
	{
		
		processSubmission(detailForm, awardForm, bodyForm, budgetForm,deptForm, bodyQuestForm, bodyDetailsForm
							, userForm, uploadForm);
		return "Successfully Submitted";
		
		
	}
	private void processSubmission( DetailForm detailForm,
					AwardTypeForm awardForm,
					BodyForm bodyForm,
					BudgetForm budgetForm,
					DepartmentForm deptForm,
					BodyQuestionsForm bodyQuestForm,
					BodyDetailsForm bodyDetailsForm,
					UserForm userForm,
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
		
		
		
		//save proposal to database
		proposalDao.addNewOrUpdateProposal(proposal);
		
		int proposalID = proposal.getProposalId();
		
		
		
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
		
		//create the file on the server 
		
		
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
				
				// store saved file locations to  database
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
