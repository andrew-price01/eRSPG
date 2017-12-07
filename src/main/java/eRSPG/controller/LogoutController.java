package eRSPG.controller;

import eRSPG.Repository.UserDAO;
import eRSPG.Repository.UserRoleDAO;
import eRSPG.config.Constants;
import eRSPG.model.User;
import eRSPG.model.UserRole;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LogoutController {

    @Autowired
    protected UserDAO userDAO;
    @Autowired
    protected UserRoleDAO userRoleDAO;
    // what I think the staff affiliation might look like / may be removed later
    private static String STAFF_AFFILIATION = "staff:weber.edu";

    @RequestMapping("/eRSPG/logout")
    public String logout(HttpServletRequest request,
                HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        request.getSession().invalidate();
        return "redirect:"+ Constants.CAS_URL_LOGOUT_SUCCESS;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,
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
                List affiliations = (List)attributes.get(Constants.CAS_ATTRIBUTE_MEMBEROF);
                boolean isStaff = affiliations.contains(STAFF_AFFILIATION); // Still need to see what this memberOf looks like
                // if the user logging in is staff and they are not already in the database add the user to the database
                User user = getNewUserFromDatabase(username);
                if(user == null){
                    // check they are staff
                    if(isStaff){
                        // create a user
                        String wNumber = attributes.get(Constants.CAS_ATTRIBUTE_WNUMBER).toString();
                        String email = attributes.get(Constants.CAS_ATTRIBUTE_EMAIL).toString();
                        String displayName = attributes.get(Constants.CAS_ATTRIBUTE_DISPLAYNAME).toString();
                        int index = displayName.indexOf(" ");
                        String firstName = displayName.substring(0, index);
                        String lastName = displayName.substring(index+1);
                        addNewUserToDatabase(email, firstName, lastName, username);
                        // query db again because we want the userID in the User object
                        user = getNewUserFromDatabase(username);
                        int userID = user.getUserId();
                        addNewUserRoleToDatabase(userID, Constants.USERROLE_USER); // roletype = 1 means User , the default will actually be 1 for lowest authorities
                        // add user to the session
                        addUserInformationToSession(request, response, user);
                        return "redirect:/eRSPG/home";
                    }else{
                        //user is not staff and not in database then logout
                        // decided to go with redirect to logout and invalidate the session
                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                        if(authentication != null){
                            new SecurityContextLogoutHandler().logout(request, response, authentication);
                        }
                        request.getSession().invalidate();
                        return "redirect:"+ Constants.CAS_URL_LOGOUT;
                    }
                }else{
                    // user is in database, add to session and redirect
                    addUserInformationToSession(request, response, user);
                    return "redirect:/eRSPG/home";
                }
            }
        }
        // user already in session and DB so redirect
        return "redirect:/eRSPG/home";
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
