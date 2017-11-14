package eRSPG.security;

import eRSPG.Repository.UserDAO;
import eRSPG.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        String login = token.getPrincipal().toString();
        String lowercaseUsername = login.toLowerCase();
        log.debug("Authenticating {}", login);

//        User userFromDatabase = userImpl.findUserByUsername(lowercaseUsername);
//        if (userFromDatabase == null) {
//            throw new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the database");
//        }
//        else if (!userFromDatabase.getActivated()) {
//            throw new UserNotActivatedException("User " + lowercaseUsername + " was not activated");
//        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Authority authority : userFromDatabase.getAuthorities()) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
//            grantedAuthorities.add(grantedAuthority);
//        }
        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new org.springframework.security.core.userdetails.User(lowercaseUsername,lowercaseUsername, grantedAuthorities);
    }
}
