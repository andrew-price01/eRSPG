package eRSPG.controller;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
	public static String STAFF_AFFILIATION = "staff:weber.edu";

	@RequestMapping("/eRSPG/home")
    public String home(){
//	public @ResponseBody
//	String home(HttpServletRequest request,
//				HttpServletResponse response) {

		// The CAS client puts the Principal into the Request:
//		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
//		if(principal != null){
//            String uni = principal.getName();
//        }
//
//		// Check if the user has a staff affil:
//		Map attributes = (principal==null)
//				? new HashMap()
//				: principal.getAttributes();
//		List affiliations = (List)attributes.get("affiliation");
//		boolean isStaff = affiliations.contains(STAFF_AFFILIATION);
//		if(isStaff){
//			return "home";
//		}
		return "home";
	}
}
