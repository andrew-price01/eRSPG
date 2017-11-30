package eRSPG.controller;

import com.google.common.collect.ImmutableMap;
import eRSPG.Repository.*;
import eRSPG.model.*;
import eRSPG.model.form.*;
import eRSPG.util.PersistProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import eRSPG.Repository.DepartmentDAO;
import eRSPG.Repository.EssayAnswerDAO;
import eRSPG.Repository.FileUploadDAO;
import eRSPG.Repository.FundDAO;
import eRSPG.Repository.ProposalDAO;
import eRSPG.Repository.RequestAwardDAO;
import eRSPG.Repository.SemesterDAO;
import eRSPG.Repository.UserDAO;
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
import eRSPG.model.form.UserForm;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"departmentForm","detailForm","awardTypeForm","uploadForm","budgetForm","bodyForm","bodyDetailsForm","bodyQuestionsForm", "userForm"})
public class ProposalController {
	
	/**
	 * Dependency injection for data access objects.
	 * 
	 */

    @Qualifier("awardTypeDao")
    @Autowired
    protected AwardTypeDAO awardTypeDAO;

    @Autowired
    protected ProjectTypeDAO projectTypeDAO;

	@Autowired
	protected ProposalDAO proposalDao;
	
	@Autowired
	private RequestAwardDAO requestAwardDao;
	
	@Autowired
	protected DepartmentDAO departmentDAO;
	
	@Autowired
	private SemesterDAO semesterDAO;
	
	@Autowired
	private FundDAO fundDAO;
	
	@Autowired
	private EssayAnswerDAO essayAnswerDAO;
	
	@Autowired
	private FileUploadDAO fileUploadDAO;

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected ProposalStatusDAO proposalStatusDAO;
	
	final String uploadDirectory = "C:/eRSPG/fileAttachments/"; //directory that store file attachments
	private static final String SUBMITTED_STATUS= "SUBMITTED";

	public String getNextPage(@RequestParam("nextPage") String nextPage) {
		return nextPage;
	}


	@RequestMapping(value = "/eRSPG/proposal", method = RequestMethod.GET)
	public @ResponseBody List<ProposalDTO> proposalListByUserId(
			@RequestParam(value = "userId", defaultValue = "", required = false) String userId) {
		Integer id = userId == null || userId.equals("") ? null : Integer.parseInt(userId);
		List<Proposal> proposals = id == null ?
				proposalDao.findAllProposals() :
				proposalDao.findProposalByUserId(id);

		return proposals.stream()
				.map(p -> new
                    ProposalDTO(
                        p,
                        departmentDAO.findDepartment(p.getDepartmentId()),
                        p.getUserId() == null ? new User("","") : userDAO.findUserById(p.getUserId()),
                        proposalStatusDAO.findProposalStatus(p.getProposalStatus())))
				.collect(Collectors.toList());
	}

    @RequestMapping(value="/eRSPG/proposal/index", method=RequestMethod.GET)
    public String UserForm(Model model){
        String contentPage = "proposalStart.jsp";
        UserForm userForm = new UserForm();

        model.addAttribute("contentPage",contentPage);
        model.addAttribute("userForm", userForm);

        return "projectIndex";
    }


    @RequestMapping(value="/eRSPG/proposal/index", method=RequestMethod.POST)
    public String saveUserForm(@ModelAttribute @Valid UserForm userForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
    {
        //for debugging
        String userinfo = "User Info:  "+ "Name : " + userForm.getFirstName() + "  " + userForm.getLastName() + "    Email: " + userForm.getUserEmail();

        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalStart.jsp");
            return "projectIndex";
        }

        User user = checkIfUserAlreadyExists(userForm);
        if(user == null){
            addNewUserToDatabase(userForm);

            // add user to the session here ( We wont need this soon as index will be removed )
        }

        //return "redirect:/proposal/body";
        return "redirect:/eRSPG/" + nextPage;
    }

    @RequestMapping("/eRSPG/proposal/start")
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

        // for debugging
        String userinfo = "User Info:  "+ "Name : " + userForm.getFirstName() + "  " + userForm.getLastName() + "    Email: " + userForm.getUserEmail();

        // We need to add the user info to the user form here from the user stored in a session
        //User user = new User();
        User user = PersistProposal.getDummyUser(); // replaced by an actual user in the future
        Proposal proposal =  proposalDao.findIncompleteProposalByUserId(user.getUserId());

        if(proposal != null){
            deptForm.LoadProposalIntoForm(proposal);
            detailForm.LoadProposalIntoForm(proposal);
            awardForm.LoadProposalIntoForm(proposal);
            budgetForm.LoadProposalIntoForm(proposal);
          //bodyForm.LoadProposalIntoForm(proposal);
            detailForm.LoadProposalIntoForm(proposal);
          //bodyQuestionsForm.LoadProposalIntoForm(proposal);

        }


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

        //return "redirect:/eRSPG/proposal/department";		// why is department turned to detail?
        return "redirect:/eRSPG/proposal/detail";
    }

    @RequestMapping(value="/eRSPG/proposal/detail", method=RequestMethod.GET)
    public String proposalForm(Model model){

        String contentPage = "proposalDetail.jsp";
        model.addAttribute("contentPage",contentPage);


        return "projectIndex";
    }

    @RequestMapping(value="/eRSPG/proposal/detail", method=RequestMethod.POST)
    public String saveProposalDetail(@ModelAttribute @Valid DetailForm detailForm, BindingResult result,Model model, @RequestParam("nextPage") String nextPage)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalDetail.jsp");
            return "projectIndex";
        }

        User user = PersistProposal.getDummyUser(); // replace by logged in user
        saveProposalState(detailForm,user.getUserId());

        //return "redirect:/proposal/awardType";
        return "redirect:/eRSPG/" + nextPage;
    }

    @RequestMapping(value="/eRSPG/proposal/department", method=RequestMethod.GET)
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

    @RequestMapping(value="/eRSPG/proposal/department", method=RequestMethod.POST)
    public String saveDepartmentForm(@ModelAttribute @Valid DepartmentForm deptForm, BindingResult result,Model model, @RequestParam("nextPage") String nextPage)
    {
        //String contentPage = "proposalDepartment.jsp";
        //model.addAttribute("contentPage",contentPage );

        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalDepartment.jsp");
            return "projectIndex";
        }

        User user = PersistProposal.getDummyUser(); // replace by logged in user
        saveProposalState(deptForm,user.getUserId());

        System.out.println(nextPage);

        //return "redirect:/proposal/detail";
        //return "redirect:/proposal/awardType";
        return "redirect:/eRSPG/" + nextPage;
    }

	@RequestMapping(value="/eRSPG/proposal/awardType", method=RequestMethod.GET)
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

	@RequestMapping(value="/eRSPG/proposal/awardType", method=RequestMethod.POST)
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

            User user = PersistProposal.getDummyUser(); // replace by logged in user
            saveProposalState(awardForm,user.getUserId());

			model.addAttribute("semester",semester);

			model.addAttribute("contentPage", "proposalAwardType.jsp");
			return "projectIndex";
		}
		//return "redirect:/proposal/budget";
		return "redirect:/eRSPG/" + nextPage;
	}

    @RequestMapping(value="/eRSPG/proposal/budget", method=RequestMethod.GET)
    public String budgetForm(Model model){
        String contentPage = "proposalBudget.jsp";
        model.addAttribute("contentPage",contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/eRSPG/proposal/budget", method=RequestMethod.POST)
    public String saveProposalBudget(@ModelAttribute @Valid BudgetForm detailForm, BindingResult result,Model model, @RequestParam("nextPage") String nextPage)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBudget.jsp");
            return "projectIndex";
        }
        User user = PersistProposal.getDummyUser(); // replace by logged in user
        saveProposalState(detailForm,user.getUserId()); //the Form should be named budgetForm
        //return "redirect:/proposal/body";
        return "redirect:/eRSPG/" + nextPage;
    }





    @RequestMapping(value="/eRSPG/proposal/body", method=RequestMethod.GET)
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

    @RequestMapping(value="/eRSPG/proposal/body", method=RequestMethod.POST)
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
            User user = PersistProposal.getDummyUser(); // replace by logged in user
            saveProposalState(awardForm,user.getUserId());
            return "projectIndex";
        }

        //return "redirect:/proposal/bodyDetails";
        return "redirect:/eRSPG/" + nextPage;
    }

    @RequestMapping(value="/eRSPG/proposal/bodyDetails", method=RequestMethod.GET)
    public String bodyDetailsForm(Model model){
        String contentPage = "proposalBodyDetails.jsp";
        model.addAttribute("contentPage", contentPage);

        return "projectIndex";
    }

    @RequestMapping(value="/eRSPG/proposal/bodyDetails", method=RequestMethod.POST)
    public String saveBodyDetailsForm(@ModelAttribute @Valid BodyDetailsForm bodyDetailsForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBodyDetails.jsp");
            return "projectIndex";
        }

        //return "redirect:/proposal/bodyQuestions";
        return "redirect:/eRSPG/" + nextPage;
    }

    @RequestMapping(value="/eRSPG/proposal/bodyQuestions", method=RequestMethod.GET)
    public String bodyQuestionsForm(Model model){
        String contentPage = "proposalBodyQuestions.jsp";
        model.addAttribute("contentPage", contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/eRSPG/proposal/bodyQuestions", method=RequestMethod.POST)
    public String saveBodyQuestionsForm(@ModelAttribute @Valid BodyQuestionsForm bodyQuestionsForm, BindingResult result, Model model, @RequestParam("nextPage") String nextPage)
    {
        if(result.hasErrors())
        {
            model.addAttribute("contentPage", "proposalBodyQuestions.jsp");
            return "projectIndex";
        }

        //return "redirect:/proposal/upload";
        return "redirect:/eRSPG/" + nextPage;
    }

    @RequestMapping(value="/eRSPG/proposal/upload", method=RequestMethod.GET)
    public String uploadForm(Model model){
        String contentPage = "proposalUpload.jsp";
        model.addAttribute("contentPage",contentPage);
        return "projectIndex";
    }

    @RequestMapping(value="/eRSPG/proposal/upload", method=RequestMethod.POST)
    public String upload(@RequestParam("fileUpload") MultipartFile file, @ModelAttribute("uploadForm") UploadForm uploadForm
            , Model model, @RequestParam("nextPage") String nextPage){

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();


                uploadForm.setName(file.getOriginalFilename());

                uploadForm.setBytes(bytes);

                //return "redirect:/proposal/review";
                //return "redirect:/proposal/submit";
                return "redirect:/eRSPG/" + nextPage;
            } catch (Exception e) {

                model.addAttribute("failedUpload","failed to upload file!");
                model.addAttribute("contentPage","proposalUpload.jsp");
                return "redirect:/eRSPG/" + nextPage;
                //return "projectIndex";

            }
        }
        else {
            model.addAttribute("failedUpload","failed to upload file!");
            model.addAttribute("contentPage","proposalUpload.jsp");
            //return "projectIndex";
            return "redirect:/eRSPG/" + nextPage;
        }
        //return "projectIndex";
    }

    @RequestMapping("/eRSPG/proposal/review")
    public String reviewForm(
            @ModelAttribute("uploadForm") UploadForm uploadForm,
            @ModelAttribute("bodyQuestionsForm") BodyQuestionsForm bodyQuestionsForm,
            @ModelAttribute("bodyForm") BodyForm bodyForm,
            @ModelAttribute("bodyDetailsForm") BodyDetailsForm bodyDetailsForm,
            @ModelAttribute("awardTypeForm") AwardTypeForm awardTypeForm,
            @ModelAttribute("departmentForm") DepartmentForm departmentForm,
            Model model){
        String contentPage = "proposalReview.jsp";
        model.addAttribute("departmentName", departmentDAO.findDepartment(departmentForm.getDepartmentID()).getDepartmentName());
        model.addAttribute("semesterName", semesterDAO.findSemesterById(departmentForm.getSemesterID()).getSemesterName());
        model.addAttribute("awardTypeList", awardTypeDAO
                .findAwardTypesById(awardTypeForm.getAwardTypes())
                .stream()
                .map(AwardType::getAwardName)
                .collect(Collectors.toList()));

        model.addAttribute("bodyAnswers",
                ImmutableMap.builder()
                        .put("1", getAnswerText(bodyForm, 1))
                        .put("2", getAnswerText(bodyForm, 2))
                        .put("3", getAnswerText(bodyForm, 3))
                        .put("4", getAnswerText(bodyForm, 4))
                        .put("5", getAnswerText(bodyDetailsForm, 5))
                        .put("6", getAnswerText(bodyDetailsForm, 6))
                        .put("7", getAnswerText(bodyDetailsForm, 7))
                        .put("8", getAnswerText(bodyDetailsForm, 8))
                        .put("9", getAnswerText(bodyQuestionsForm,9))
                        .put("10", getAnswerText(bodyQuestionsForm,10))
                        .put("11", getAnswerText(bodyQuestionsForm, 11))
                        .put("12", getAnswerText(bodyQuestionsForm,12))
                        .put("13", getAnswerText(bodyQuestionsForm, 13))
                        .put("14", getAnswerText(bodyQuestionsForm, 14))
                        .put("15", getAnswerText(bodyQuestionsForm, 15)).build());
        model.addAttribute("projectTypeName", projectTypeDAO.findProjectType(awardTypeForm.getProjectTypeID()).getProjectTypeName());
        model.addAttribute("contentPage",contentPage);
        return "projectIndex";
    }

    private String getAnswerText(@ModelAttribute("bodyQuestionsForm") BodyQuestionsForm bodyForm,
                                 Integer questionId) {
        return bodyForm.generateEssayAnswers().stream()
                .filter(essayAnswer -> essayAnswer.getQuestionId() == questionId)
                .map(EssayAnswer::getAnswer)
                .reduce((s, s2) -> s).orElse("No Answer");
    }

    private String getAnswerText(@ModelAttribute("bodyForm") BodyForm bodyForm,
                                 Integer questionId) {
                return bodyForm.generateEssayAnswers().stream()
                        .filter(essayAnswer -> essayAnswer.getQuestionId() == questionId)
                        .map(EssayAnswer::getAnswer)
                        .reduce((s, s2) -> s).orElse("No Answer");
    }

    private String getAnswerText(@ModelAttribute("bodyDetailsForm")BodyDetailsForm bodyForm,
                                 Integer questionId) {
        return bodyForm.generateEssayAnswers().stream()
                .filter(essayAnswer -> essayAnswer.getQuestionId() == questionId)
                .map(EssayAnswer::getAnswer)
                .reduce((s, s2) -> s).orElse("No Answer");
    }


    @RequestMapping("/eRSPG/proposal/submit")
    public String submit(@ModelAttribute("detailForm") DetailForm detailForm,
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
        return "proposalSubmit";

    }

	@RequestMapping(value = "/eRSPG/proposal/list", method = RequestMethod.GET)
	public String proposalList(
	        @RequestParam(value = "userId", defaultValue = "", required = false) String userId,
            Model model) {

		model.addAttribute("proposalList", proposalListByUserId(userId));
        return "proposalList";
	}

	@RequestMapping(value = "/eRSPG/proposalStatus", method = RequestMethod.GET)
	public @ResponseBody List<ProposalStatus> proposalStatusList(
			@RequestParam(value = "name", defaultValue = "", required = false) String name) {

		name = name == null ? "" : name.toUpperCase();

		if (name.isEmpty()) {
			List<ProposalStatus> statuses = proposalStatusDAO.findAllProposalStatuses();
			return statuses;
		} else {
			ProposalStatus status = proposalStatusDAO.findProposalStatusByName(name);
			return status == null ? Collections.EMPTY_LIST : Collections.singletonList(status);
        }
	}

	@RequestMapping(value = "/eRSPG/proposal/{id}/status", method = RequestMethod.PUT)
	public @ResponseBody Proposal updateProposalStatus(
			@PathVariable String id,
			@RequestBody String statusName) {

		Integer proposalId = id == null ? null : Integer.parseInt(id);
        statusName = statusName == null ? "" : statusName.toUpperCase();
        ProposalStatus status = proposalStatusDAO.findProposalStatusByName(statusName);

        Proposal proposal;
        if (proposalId != null) {
             proposal = proposalDao.findProposal(proposalId);
        } else {
            return null;
        }

		if (status != null && proposal != null) {
			proposal.setProposalStatus(status.getProposalStatusId());
			proposalDao.addNewOrUpdateProposal(proposal);
			return proposal;
		} else {
			return null;
		}
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

		Proposal proposal = new Proposal();// find incomplete proposal by user id

		// weird work around for user data
        userForm.setUserEmail(detailForm.getProposalEmail());
        User user = checkIfUserAlreadyExists(userForm);
        if(user != null){
            int userID = user.getUserId();
            // added code to get user id
            proposal.setUserId(userID);
        }

		proposal.setProjectDirector(detailForm.getProjectDirector());
		//proposal.setProposalComplete(true);
		proposal.setProposalStatus(proposalStatusDAO.findProposalStatusByName(SUBMITTED_STATUS).getProposalStatusId());
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
			// add code to check if directory exists and if not make it with write permissions
            File directory = new File(this.uploadDirectory);
			if (! directory.exists()){
                // Throws exception on failure
                directory.mkdirs();
                directory.setReadable(true);
                directory.setWritable(true);
                directory.setExecutable(true);
			}

			file.createNewFile();
            file.setReadable(true);
            file.setWritable(true);
            file.setExecutable(true);
			OutputStream output = new FileOutputStream(file);

            // Added this code to stop null exceptions because duh not everyone uploads a file with submission
			if(uploadForm.getBytes() != null){
                output.write(uploadForm.getBytes());
            }

			output.close();

            List<UploadFile> uploadFiles = uploadForm.generateUploadFiles();
            // Added this code to stop null exceptions because duh not everyone uploads a file with submission
            if(uploadFiles != null && uploadFiles.size() > 0){
                for (UploadFile uploadFile : uploadFiles) {
                    uploadFile.setProposalId(proposalID);
                    uploadFile.setPath(this.uploadDirectory + fileName);
                    uploadFile.setFileName(uploadForm.getName());

                    // store saved file locations to  database
                    fileUploadDAO.save(uploadFile);
                }
            }

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//TODO: clear session form data
		
	}

	private User checkIfUserAlreadyExists(UserForm userForm){
        // user added if doesn't exist
        User user = null;
        try{
            user = userDAO.findUserByEmail(userForm.getUserEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    private void addNewUserToDatabase(UserForm userForm) {
        User newUser = new User();
        newUser.setEmail(userForm.getUserEmail());
        newUser.setFirstName(userForm.getFirstName());
        newUser.setLastName(userForm.getLastName());
        userDAO.addNewOrUpdateUser(newUser);
    }

    //stores whats in the form into the proposal then saves it into the database
    private void saveProposalState(BaseForm bf,Integer userId) {
        Proposal proposal =  proposalDao.findIncompleteProposalByUserId(userId);
	    bf.LoadFormIntoProposal(proposal);
	    proposalDao.addNewOrUpdateProposal(proposal);
    }

}
