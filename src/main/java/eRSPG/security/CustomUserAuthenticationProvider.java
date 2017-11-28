package eRSPG.security;

import java.util.ArrayList;
import java.util.Collection;

import eRSPG.Repository.RoleTypeDAO;
import eRSPG.Repository.UserDAO;
import eRSPG.Repository.UserRoleDAO;
import eRSPG.model.RoleType;
import eRSPG.model.UserRole;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;


public class CustomUserAuthenticationProvider  extends AuthenticationFilter {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private RoleTypeDAO roleTypeDAO;

    //@Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
    }

    @Transactional
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        String login = token.getPrincipal().toString();
        String lowercaseUsername = login.toLowerCase();
        //log.debug("Authenticating {}", login);

        eRSPG.model.User userFromDatabase = userDAO.findUserByUsername(lowercaseUsername);
        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the database");
        }
//        else if (userRoleFromDatabase.getRevoked() != null) {
//            throw new UserNotActivatedException("User " + lowercaseUsername + " role was revoked");
//        }

        UserRole userRoleFromDatabase = userRoleDAO.findUserRoleByUserId(userFromDatabase.getUserId());
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        RoleType roleTypeFromDatabase = roleTypeDAO.findRoleTypeByRoleTypeId(userRoleFromDatabase.getRoleTypeId());
        String roleFromDB = roleTypeFromDatabase.getRoleDesc();
        String roleUser = "ROLE_USER";
        String roleAdmin = "ROLE_ADMIN";
        String roleChair = "ROLE_CHAIRMAN";
        GrantedAuthority grantedAuthority = null;
        switch(roleFromDB){
            case "user":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
                grantedAuthorities.add(grantedAuthority);
                break;
            case "admin":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
                grantedAuthorities.add(grantedAuthority);
                grantedAuthority = new SimpleGrantedAuthority(roleAdmin);
                grantedAuthorities.add(grantedAuthority);
                break;
            case "chairman":
                grantedAuthority = new SimpleGrantedAuthority(roleUser);
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
