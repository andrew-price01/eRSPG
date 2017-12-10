package eRSPG.config;

import eRSPG.security.CustomUserDetailsService;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.authentication.Saml11AuthenticationFilter;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.*;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(springSecurityFilterChain(), FilterChainProxy.class)
                .httpBasic().realmName("eRSPG")
                .and()
                .logout()
                    .logoutUrl("/eRSPG/logout")
                    .logoutSuccessUrl(Constants.CAS_URL_LOGOUT_SUCCESS)
                    .logoutSuccessHandler((LogoutSuccessHandler) securityContextLogoutHandler())
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                .authorizeRequests()
                    .antMatchers("/welcome", "/about", "/contact").permitAll()
                    .antMatchers("/eRSPG/home").hasAuthority("ROLE_USER")
                    .antMatchers("/eRSPG/proposal/**").hasAuthority("ROLE_USER")
                    .antMatchers("/eRSPG/comittee/**").hasAuthority("ROLE_COMMITTEE")
                    .antMatchers("/eRSPG/admin/**").hasAuthority("ROLE_ADMIN")
                    .antMatchers("/eRSPG/chairman/**").hasAuthority("ROLE_CHAIRMAN")
                    .anyRequest().authenticated()
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preAuthAuthProvider());
    }

    @Bean
    public FilterChainProxy springSecurityFilterChain(){
        // To change to Cas20 protocol change the authicationFilter and ticketValidationFilter below
        List listOfFilterChains = new ArrayList();
        listOfFilterChains.add(new DefaultSecurityFilterChain(
                new AntPathRequestMatcher("/eRSPG/**"),
                authenticationFilterSaml(), ticketValidationFilterSaml(), wrappingFilter(), sif(),
                j2eePreAuthFilter(), logoutFilter(), etf(), fsi()));
        return new FilterChainProxy(listOfFilterChains);
    }

    @Bean
    public SecurityContextPersistenceFilter sif(){
        return new SecurityContextPersistenceFilter();
    }

    @Bean
    public PreAuthenticatedAuthenticationProvider preAuthAuthProvider(){
        PreAuthenticatedAuthenticationProvider mPreAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
        mPreAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
        return mPreAuthenticatedAuthenticationProvider;
    }

    @Bean
    public UserDetailsByNameServiceWrapper userDetailsServiceWrapper(){
        UserDetailsByNameServiceWrapper mUserDetailsByNameServiceWrapper = new UserDetailsByNameServiceWrapper();
        mUserDetailsByNameServiceWrapper.setUserDetailsService(getUserService());
        return mUserDetailsByNameServiceWrapper;
    }

    @Bean
    public CustomUserDetailsService getUserService(){
        CustomUserDetailsService mCustomUserDetailsService = new CustomUserDetailsService();
        return mCustomUserDetailsService;
    }

    @Bean
    public Http403ForbiddenEntryPoint preAuthEntryPoint(){
        return new Http403ForbiddenEntryPoint();
    }

    @Bean
    public J2eePreAuthenticatedProcessingFilter j2eePreAuthFilter(){
        J2eePreAuthenticatedProcessingFilter j2eePreAuthFilter = new J2eePreAuthenticatedProcessingFilter();
        j2eePreAuthFilter.setAuthenticationManager(getAuthenticationManager());
        j2eePreAuthFilter.setAuthenticationDetailsSource(authenticationDetailsSource());
        j2eePreAuthFilter.setContinueFilterChainOnUnsuccessfulAuthentication(false);
        return j2eePreAuthFilter;
    }

    @Bean
    public AuthenticationManager getAuthenticationManager(){
        try{
            return authenticationManager();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public WebAuthenticationDetailsSource authenticationDetailsSource(){
        return new WebAuthenticationDetailsSource();
    }

    @Bean
    public LogoutFilter logoutFilter(){
        LogoutFilter logoutFilter = new LogoutFilter(Constants.APP_SERVER, securityContextLogoutHandler());
        return logoutFilter;
    }

    @Bean
    public SecurityContextLogoutHandler securityContextLogoutHandler(){
        return new SecurityContextLogoutHandler();
    }

    @Bean
    public ExceptionTranslationFilter etf(){
        ExceptionTranslationFilter etf = new ExceptionTranslationFilter(preAuthEntryPoint());
        return etf;
    }

    @Bean
    public AffirmativeBased httpRequestAccessDecisionManager(){
        List<AccessDecisionVoter<?>> roleVoters = new ArrayList<>();
        roleVoters.add(roleVoter());
        roleVoters.add(new AuthenticatedVoter());
        roleVoters.add(new WebExpressionVoter());
        AffirmativeBased mAffirmativeBased = new AffirmativeBased(roleVoters);
        mAffirmativeBased.setAllowIfAllAbstainDecisions(false);
        return mAffirmativeBased;
    }

    @Bean
    public FilterSecurityInterceptor fsi(){
        FilterSecurityInterceptor mFilterSecurityInterceptor = new FilterSecurityInterceptor();
        mFilterSecurityInterceptor.setAuthenticationManager(getAuthenticationManager());
        mFilterSecurityInterceptor.setAccessDecisionManager(httpRequestAccessDecisionManager());
        mFilterSecurityInterceptor.setSecurityMetadataSource(filterInvocationSecurityMetadataSource());
        return mFilterSecurityInterceptor;
    }

    @Bean
    public RoleVoter roleVoter(){
        return new RoleVoter();
    }

    @Bean
    public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource(){
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();
        requestMap.put(new AntPathRequestMatcher("/eRSPG/home"), SecurityConfig.createList("hasRole('ROLE_USER')"));
        requestMap.put(new AntPathRequestMatcher("/eRSPG/proposal/**"), SecurityConfig.createList("hasRole('ROLE_USER')"));
        requestMap.put(new AntPathRequestMatcher("/eRSPG/committee**"), SecurityConfig.createList("hasRole('ROLE_COMMITTEE')"));
        requestMap.put(new AntPathRequestMatcher("/eRSPG/admin/**"),SecurityConfig.createList("hasRole('ROLE_ADMIN')"));
        requestMap.put(new AntPathRequestMatcher("/eRSPG/chairman/**"),SecurityConfig.createList("hasRole('ROLE_CHAIRMAN')"));
        FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, new DefaultWebSecurityExpressionHandler());
        return filterInvocationSecurityMetadataSource;
    }

    @Bean
    public SecurityContextHolderAwareRequestFilter securityContextHolderAwareRequestFilter(){
        return new SecurityContextHolderAwareRequestFilter();
    }


    @Bean
    public Saml11AuthenticationFilter authenticationFilterSaml(){
        Saml11AuthenticationFilter authenticationFilter = new Saml11AuthenticationFilter();
        authenticationFilter.setCasServerLoginUrl(Constants.CAS_URL_LOGIN);
        authenticationFilter.setService(Constants.CAS_SERVICE_URL);
        authenticationFilter.setServerName(Constants.CAS_SERVER);
        authenticationFilter.setRenew(false);
        authenticationFilter.setGateway(false);

        return authenticationFilter;
    }

    @Bean
    public AuthenticationFilter authenticationFilter(){
        AuthenticationFilter mAuthenticationFilter = new AuthenticationFilter();
        mAuthenticationFilter.setCasServerLoginUrl(Constants.CAS_URL_LOGIN);
        mAuthenticationFilter.setService(Constants.CAS_SERVICE_URL);
        mAuthenticationFilter.setServerName(Constants.CAS_SERVER);
        mAuthenticationFilter.setRenew(false);
        mAuthenticationFilter.setGateway(false);
        return mAuthenticationFilter;
    }

    @Bean
    public Saml11TicketValidationFilter ticketValidationFilterSaml(){
        Saml11TicketValidationFilter ticketValidationFilter = new Saml11TicketValidationFilter();
        ticketValidationFilter.setServerName(Constants.CAS_SERVER);
        ticketValidationFilter.setService(Constants.CAS_SERVICE_URL);
        ticketValidationFilter.setUseSession(true);
        ticketValidationFilter.setRedirectAfterValidation(true);
        ticketValidationFilter.setExceptionOnValidationFailure(true);
        ticketValidationFilter.setTicketValidator(ticketValidatorSaml());
        return ticketValidationFilter;
    }

    @Bean
    public Saml11TicketValidator ticketValidatorSaml(){
        Saml11TicketValidator ticketValidator = new Saml11TicketValidator(Constants.CAS_URL_PREFIX);
        return ticketValidator;
    }

//    @Bean
//    public Cas20ProxyReceivingTicketValidationFilter ticketValidationFilterCas20(){
//        Cas20ProxyReceivingTicketValidationFilter mCas20ProxyReceivingTicketValidationFilter = new Cas20ProxyReceivingTicketValidationFilter();
//        mCas20ProxyReceivingTicketValidationFilter.setServerName(Constants.CAS_SERVER);
//        mCas20ProxyReceivingTicketValidationFilter.setService(Constants.CAS_SERVICE_URL);
//        //mCas20ProxyReceivingTicketValidationFilter.setProxyReceptorUrl("/proxy/receptor");
//        mCas20ProxyReceivingTicketValidationFilter.setUseSession(true);
//        mCas20ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
//        mCas20ProxyReceivingTicketValidationFilter.setExceptionOnValidationFailure(true);
//        mCas20ProxyReceivingTicketValidationFilter.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
//        mCas20ProxyReceivingTicketValidationFilter.setTicketValidator(cas20ProxyTicketValidator());
//        return mCas20ProxyReceivingTicketValidationFilter;
//    }

//    @Bean
//    public Cas20ProxyTicketValidator cas20ProxyTicketValidator(){
//        return new Cas20ProxyTicketValidator(Constants.CAS_URL_PREFIX);
//    }

//    @Bean
//    public Cas20ServiceTicketValidator ticketValidator(){
//        Cas20ServiceTicketValidator mCas20ServiceTicketValidator = new Cas20ServiceTicketValidator(Constants.CAS_URL_PREFIX);
//        mCas20ServiceTicketValidator.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
//        mCas20ServiceTicketValidator.setProxyCallbackUrl(Constants.CAS_SERVICE_URL);
//        return mCas20ServiceTicketValidator;
//    }

    @Bean
    public ProxyGrantingTicketStorageImpl proxyGrantingTicketStorage(){
        return new ProxyGrantingTicketStorageImpl();
    }


    @Bean
    public HttpServletRequestWrapperFilter wrappingFilter(){
        return  new HttpServletRequestWrapperFilter();
    }

}
