package eRSPG.security;

import eRSPG.Repository.RoleTypeDAO;
import eRSPG.Repository.UserDAO;
import eRSPG.Repository.UserRoleDAO;
import eRSPG.model.RoleType;
import eRSPG.model.User;
import eRSPG.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private RoleTypeDAO roleTypeDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String roleUser = "ROLE_USER";
        String roleCommittee = "ROLE_COMMITTEE";
        String roleAdmin = "ROLE_ADMIN";
        String roleChair = "ROLE_CHAIR";
        String lowercaseUsername = username.toLowerCase();

        User userFromDatabase = userDAO.findUserByUsername(lowercaseUsername);
        if (userFromDatabase == null) {
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleUser);
            grantedAuthorities.add(grantedAuthority);
            return new org.springframework.security.core.userdetails.User(lowercaseUsername,lowercaseUsername, grantedAuthorities);
            //throw new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the database");
        }
//        else if (userRoleFromDatabase.getRevoked() != null) {
//            throw new UserNotActivatedException("User " + lowercaseUsername + " role was revoked");
//        }

        UserRole userRoleFromDatabase = userRoleDAO.findUserRoleByUserId(userFromDatabase.getUserId());
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        RoleType roleTypeFromDatabase = roleTypeDAO.findRoleTypeByRoleTypeId(userRoleFromDatabase.getRoleTypeId());
        String roleFromDB = roleTypeFromDatabase.getRoleDesc();
        GrantedAuthority grantedAuthority = null;
        switch(roleFromDB){
            case "user":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
                grantedAuthorities.add(grantedAuthority);
                break;
            case "committee":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleCommittee);
                grantedAuthorities.add(grantedAuthority);
            case "admin":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleCommittee);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleAdmin);
                grantedAuthorities.add(grantedAuthority);
                break;
            case "chairman":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleCommittee);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleAdmin);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleChair);
                grantedAuthorities.add(grantedAuthority);
                break;
            default:
                break;
        }
        return new org.springframework.security.core.userdetails.User(lowercaseUsername,lowercaseUsername, grantedAuthorities);
    }
}
