package eRSPG.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import eRSPG.Repository.FileUploadDAO;
import eRSPG.model.UploadFile;

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
	
	@RequestMapping(value="/proposal/upload",method=RequestMethod.GET)
	public String uploadForm(Model model){
		String contentPage = "proposalUpload.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@RequestMapping(value="/proposal/upload",method=RequestMethod.POST)
	public String saveupload(Model model){
		String contentPage = "proposalUpload.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
	@Autowired
    private FileUploadDAO fileUploadDao;
	
    @RequestMapping(value = "/proposal/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
          
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                 
                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                fileUploadDao.save(uploadFile);               
            }
        }
  
        return "Success";
    }  
    
   
	
	@RequestMapping("/proposal/review")
	public String reviewForm(Model model){
		String contentPage = "proposalReview.jsp";
		model.addAttribute("contentPage",contentPage);
		return "projectIndex";
	}
	
}
