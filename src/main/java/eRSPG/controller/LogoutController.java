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
    /* example of an employees memberOf attribute
        memebrOf : ["CN=WSU Employees,OU=groups,DC=ad,DC=weber,DC=edu" , "CN=WSU_Faculty,OU=groups,DC=ad,DC=weber,DC=edu"]
     */

    // what the staff affiliation looks like in attributes
    private static String STAFF_AFFILIATION = "CN=WSU_Faculty";

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
                List affiliations = (List)attributes.get(Constants.CAS_ATTRIBUTE_MEMBEROF); // from example above each index in this list is a string of comma separated values
                // maybe make another List<sting> affils
                /* ex.
                    boolean isStaff = false;
                    foreach(String s: affiliations){
                        List<sting> subAffiliations = Arrays.asList(s.split("\\s*,\\s*"));
                        foreach(String s2: subAffiliations){
                            if(s2.contains(STAFF_AFFILITATION){
                                isStaff = true
                                break;
                             }
                         }
                         if(isStaff){
                            break;
                         }
                     }
                 */
                boolean isStaff = affiliations.contains(STAFF_AFFILIATION); // Still need to see what this memberOf looks like
                // if the user logging in is staff and they are not already in the database add the user to the database
                User user = getNewUserFromDatabaseByUsername(username);
                if(user == null){
                    // check for them by email
                    String email = attributes.get(Constants.CAS_ATTRIBUTE_EMAIL).toString();
                    user = getNewUserFromDatabaseByEmail(email);
                    // user not in db by email or username
                    if(user == null){
                        // check they are staff
                        if(isStaff){
                            // create a user
                            String wNumber = attributes.get(Constants.CAS_ATTRIBUTE_WNUMBER).toString();
                            //email = attributes.get(Constants.CAS_ATTRIBUTE_EMAIL).toString();
                            String displayName = attributes.get(Constants.CAS_ATTRIBUTE_DISPLAYNAME).toString();
                            int index = displayName.indexOf(" ");
                            String firstName = displayName.substring(0, index);
                            String lastName = displayName.substring(index+1);
                            addNewUserToDatabase(email, firstName, lastName, username);
                            // query db again because we want the userID in the User object
                            user = getNewUserFromDatabaseByUsername(username);
                            int userID = user.getUserId();
                            addNewUserRoleToDatabase(userID, Constants.USERROLE_USER); // roletype = 1 means User , the default will actually be 1 for lowest authorities
                            // add user to the session
                            addUserInformationToSession(request, response, user);
                            return "redirect:/eRSPG/home";
                        }else{
                            //user is not staff and not in database then logout
                            // decided to go with redirect to logout and invalidate the session
                            return "redirect:/eRSPG/logout";
                        }
                    }
                    else{
                        // user in DB but without a username
                        user = updateUserNameInDatabase(user, username);
                        // check for W#
                        if(user.getwNumber() == null || user.getwNumber().isEmpty()){
                            // no W# retrieve it from Cas attribute
                            String wNum = attributes.get(Constants.CAS_ATTRIBUTE_WNUMBER).toString();
                            // if retrieved update the user's W#
                            if(wNum != null && !wNum.isEmpty()){
                                user = updateWNumberInDatabase(user, wNum);
                            }
                        }
                        int userID = user.getUserId();
                        // check for user role
                        UserRole userRole = userRoleDAO.findUserRoleByUserId(userID);
                        if(userRole == null){
                            addNewUserRoleToDatabase(userID, Constants.USERROLE_USER); // roletype = 1 means User , the default will actually be 1 for lowest authorities
                        }
                        // add user to the session
                        addUserInformationToSession(request, response, user);
                        return "redirect:/eRSPG/home";
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

    private User updateUserNameInDatabase(User user, String username){
        user.setUsername(username);
        userDAO.addNewOrUpdateUser(user);
        return user;
    }

    private User updateWNumberInDatabase(User user, String wNumber){
        user.setwNumber(wNumber);
        userDAO.addNewOrUpdateUser(user);
        return user;
    }

    private void addNewUserRoleToDatabase(int userID, int roleType) {
        UserRole ur = new UserRole();
        ur.setRoleTypeId(roleType); // 1 = user , 2=admin, 3 = chairman
        ur.setUserId(userID);
        userRoleDAO.addNewOrUpdateUserRole(ur);
    }

    private User getNewUserFromDatabaseByUsername(String username){
        User user = null;
        try{
            user = userDAO.findUserByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    private User getNewUserFromDatabaseByEmail(String email){
        User user = null;
        try{
            user = userDAO.findUserByEmail(email);
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
