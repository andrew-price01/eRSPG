package eRSPG.controller;

import eRSPG.Repository.UserDAO;
import eRSPG.config.WebSecurityConfig;
import eRSPG.model.User;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    @Autowired
    protected UserDAO userDAO;
	private static String STAFF_AFFILIATION = "staff:weber.edu";

	@RequestMapping("/eRSPG/home")
	public String home(HttpServletRequest request,
				HttpServletResponse response) {

		// The CAS client puts the Principal into the Request:
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		//check if user is already in the session
        Object userObject = null;
		try{
            userObject = request.getSession().getAttribute("User");
        }catch(Exception ex){
		    ex.printStackTrace();
        }
        // if user is not in session
		if(userObject == null){
            String username = null;
            if(principal != null){
                username = principal.getName();
            }

            // Check if the user has a staff affil:
            Map attributes = (principal==null)
                    ? new HashMap()
                    : principal.getAttributes();

            if(!attributes.isEmpty() && username != null){
                List affiliations = (List)attributes.get("affiliation");  //attribute string will change according to Webers naming conventions (eg affiliation)
                boolean isStaff = affiliations.contains(STAFF_AFFILIATION);
                // if the user loging in is staff and they are not already in the database add the user to the database
                if(isStaff){
                    User user = getNewUserFromDatabase(username);
                    if(user == null){
                        // create a user
                        String firstName = attributes.get("First_Name").toString(); //attribute string will change according to Webers naming conventions (eg First_Name)
                        String lastName = attributes.get("Last_Name").toString();  //attribute string will change according to Webers naming conventions (eg Last_Name)
                        String email = attributes.get("Email").toString();        //attribute string will change according to Webers naming conventions (eg Email)
                        addNewUserToDatabase(email, firstName, lastName, username);
                        // query db again because we want the userID in the User object
                        user = getNewUserFromDatabase(username);
                    }
                    addUserInformationToSession(request, response, user);
                    return "home";
                }
            }else{
                // this will be removed but is here while we can't get attributes
                return "home";
            }
        }else{
		    // user already in session and DB
            return "home";
        }

		// actually redirect to error page or welcome
		return "redirect:/welcome";
	}

    private void addNewUserToDatabase(String email, String fName, String lName, String userName) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setFirstName(fName);
        newUser.setLastName(lName);
        String username = userName.toLowerCase();
        newUser.setUsername(username);
        userDAO.addNewOrUpdateUser(newUser);
    }

    private User getNewUserFromDatabase(String username){
        User user = null;
        try{
            user = userDAO.findUserByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    private void addUserInformationToSession(HttpServletRequest request,
                                             HttpServletResponse response, User user){

        request.getSession().setAttribute("User", user);
    }
}
