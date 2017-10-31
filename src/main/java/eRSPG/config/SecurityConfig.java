package eRSPG.config;

import eRSPG.security.*;
import eRSPG.webfilters.CsrfCookieGeneratorFilter;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


//
//    @Inject
//    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
//
//    @Inject
//    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;
//
//    @Inject
//    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;
//
//    @Inject
//    private AuthenticationUserDetailsService<CasAssertionAuthenticationToken> userDetailsService;
//
//    @Bean
//    public RememberCasAuthenticationProvider casAuthenticationProvider() {
//        RememberCasAuthenticationProvider casAuthenticationProvider = new RememberCasAuthenticationProvider();
//        casAuthenticationProvider.setAuthenticationUserDetailsService(userDetailsService);
//        casAuthenticationProvider.setServiceProperties(serviceProperties());
//        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
//        casAuthenticationProvider.setKey("an_id_for_this_auth_provider_only");
//        return casAuthenticationProvider;
//    }
//
//    @Bean
//    public SessionAuthenticationStrategy sessionStrategy() {
//        SessionFixationProtectionStrategy sessionStrategy = new CustomSessionFixationProtectionStrategy();
//        sessionStrategy.setMigrateSessionAttributes(false);
//        // sessionStrategy.setRetainedAttributes(Arrays.asList("CALLBACKURL"));
//        return sessionStrategy;
//    }
//
//    @Bean
//    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
//        return new Cas20ServiceTicketValidator(CAS_URL_PREFIX);
//    }
//
//    @Bean
//    public org.springframework.security.cas.web.CasAuthenticationFilter casAuthenticationFilter() throws Exception {
//        org.springframework.security.cas.web.CasAuthenticationFilter casAuthenticationFilter = new org.springframework.security.cas.web.CasAuthenticationFilter();
//        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
//        casAuthenticationFilter.setAuthenticationDetailsSource(new RememberWebAuthenticationDetailsSource());
//        casAuthenticationFilter.setSessionAuthenticationStrategy(sessionStrategy());
//        casAuthenticationFilter.setAuthenticationFailureHandler(ajaxAuthenticationFailureHandler);
//        casAuthenticationFilter.setAuthenticationSuccessHandler(ajaxAuthenticationSuccessHandler);
//        // casAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
//        // casAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new
//        // AntPathRequestMatcher("/login", "GET"));
//        return casAuthenticationFilter;
//    }
//
//    @Bean
//    public RememberCasAuthenticationEntryPoint casAuthenticationEntryPoint() {
//        RememberCasAuthenticationEntryPoint casAuthenticationEntryPoint = new RememberCasAuthenticationEntryPoint();
//        casAuthenticationEntryPoint.setLoginUrl(CAS_URL_LOGIN);
//        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
//        //move to /app/login due to cachebuster instead of api/authenticate
//        casAuthenticationEntryPoint.setPathLogin("/eRSPG/login");
//        return casAuthenticationEntryPoint;
//    }
//
//    @Bean
//    public CustomSingleSignOutFilter singleSignOutFilter() {
//        CustomSingleSignOutFilter singleSignOutFilter = new CustomSingleSignOutFilter();
//        singleSignOutFilter.setCasServerUrlPrefix(CAS_URL_PREFIX);
//        return singleSignOutFilter;
//    }
//
//    @Bean
//    public LogoutFilter requestCasGlobalLogoutFilter() {
//        LogoutFilter logoutFilter = new LogoutFilter(CAS_URL_LOGOUT + "?service="
//                + APP_SERVICE_HOME, new SecurityContextLogoutHandler());
//        logoutFilter.setLogoutRequestMatcher(new AntPathRequestMatcher("/eRSPG/logout", "POST"));
//        return logoutFilter;
//    }
//
//    @Inject
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(casAuthenticationProvider());
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/WEB-INF/js/**.{js}")
//                .antMatchers("/WEB-INF/css/**")
//                .antMatchers("/WEB-INF/fonts/**")
//                .antMatchers("/WEB-INF/views/about")
//                .antMatchers("/WEB-INF/views/contact")
//                .antMatchers("WEB-INF/views/welcome");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterAfter(new CsrfCookieGeneratorFilter(), CsrfFilter.class)
//                .addFilterBefore(casAuthenticationFilter(), BasicAuthenticationFilter.class)
//                .addFilterBefore(singleSignOutFilter(), org.springframework.security.cas.web.CasAuthenticationFilter.class)
//                //.addFilterBefore(requestCasGlobalLogoutFilter(), LogoutFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(casAuthenticationEntryPoint())
//                .and()
//                    .logout()
//                    .logoutUrl("/eRSPG/logout")
//                    .logoutSuccessHandler(ajaxLogoutSuccessHandler)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//                    .permitAll()
//                    .and()
//                    .headers()
//                    .frameOptions()
//                    .disable()
//                .and()
//                    .authorizeRequests()
//                        .antMatchers("/eRSPG/**").authenticated()
//                        .antMatchers("/eRSPG/authenticate").authenticated()
////                        .anyRequest().authenticated()
//                        .antMatchers("/beans/**").hasAuthority(AuthoritiesConstants.ADMIN);
//
//    }
//
//    @EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
//    private static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
//        public GlobalSecurityConfiguration() {
//        }
//    }
}
