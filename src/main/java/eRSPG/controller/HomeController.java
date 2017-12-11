package eRSPG.controller;

import eRSPG.Repository.UserDAO;
import eRSPG.Repository.UserRoleDAO;
import eRSPG.model.User;
import eRSPG.model.UserRole;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
    @Autowired
    protected UserDAO userDAO;
    // this will be removed and is temporary to create default users from logins
    @Autowired
    protected UserRoleDAO userRoleDAO;
    // what I think the staff affiliation might look like / may be removed later
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

            // Check if the user has a staff affiliation
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
                        int userID = user.getUserId();
                        // add the user role to the DB for new user   NOTE: MAKE SURE TO CHANGE ROLETYPE TO 1 AFTER TESTING IS DONE
                        addNewUserRoleToDatabase(userID, 3); // roletype = 3 means chairman , the default will actually be 1 for lowest authorities

                    }
                    addUserInformationToSession(request, response, user);
                    return "home";
                }
            }else if(username != null){
                // this will be removed but is here while we can't get attributes
                // REMOVE THE WHOLE ELSE IF WHEN TESTING IS DONE
                User user = getNewUserFromDatabase(username);
                if(user == null){
                    // create a user
                    String firstName = username;
                    String lastName =  username;
                    String email =  username+"@fake.email";
                    addNewUserToDatabase(email, firstName, lastName, username);
                    // query db again because we want the userID in the User object
                    user = getNewUserFromDatabase(username);
                    int userID = user.getUserId();
                    // add the user role to the DB for new user
                    addNewUserRoleToDatabase(userID, 3); // roletype = 3 means chairman
                }
                addUserInformationToSession(request, response, user);
                return "home";
            }
        }else{
		    // user already in session and DB
            return "home";
        }

		// actually redirect to error page or welcome
		return "redirect:/eRSPG/logout";
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

    private void addNewUserRoleToDatabase(int userID, int roleType) {
        UserRole ur = new UserRole();
        ur.setRoleTypeId(roleType); // 1 = user , 2=admin, 3 = chairman
        ur.setUserId(userID);
        userRoleDAO.addNewOrUpdateUserRole(ur);
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
        int i = 0;
    }
}
