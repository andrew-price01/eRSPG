package eRSPG.config;

import eRSPG.security.CustomUserAuthenticationProvider;
import eRSPG.security.CustomUserDetailsService;
import org.jasig.cas.client.authentication.AuthenticationFilter;
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
import org.springframework.security.authentication.ProviderManager;
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
                //.addFilterBefore(springSecurityFilterChain(), FilterChainProxy.class)
                //.formLogin().loginPage("/login")
                //.and()
                .httpBasic().realmName("eRSPG")
                .and()
                .logout().logoutUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll()
                .and()
                .authorizeRequests().antMatchers("/welcome","/about", "/contact").permitAll()
                .and()
                .authorizeRequests().antMatchers("/eRSPG/**").authenticated().anyRequest().permitAll()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN")
                .and()
                .withUser("casuser").password("casuser").authorities("ROLE_USER", "ROLE_ADMIN", "ROLE_CHAIRMAN");
    }

    @Bean
    public FilterChainProxy springSecurityFilterChain(){
        /*
        <sec:filter-chain-map path-type="ant">
        <sec:filter-chain pattern="/" filters="casValidationFilter, wrappingFilter" />
        <sec:filter-chain pattern="/secure/receptor" filters="casValidationFilter" />
        <sec:filter-chain pattern="/j_spring_security_logout" filters="logoutFilter,etf,fsi" />
        <sec:filter-chain pattern="/**" filters="casAuthenticationFilter, casValidationFilter, wrappingFilter, sif,j2eePreAuthFilter,logoutFilter,etf,fsi"/>
        </sec:filter-chain-map>
        */
        List listOfFilterChains = new ArrayList();
//        listOfFilterChains.add(new DefaultSecurityFilterChain(
//                new AntPathRequestMatcher("/eRSPG"),
//                casValidationFilter(), wrappingFilter()));
        listOfFilterChains.add(new DefaultSecurityFilterChain(
                new AntPathRequestMatcher("/eRSPG/secure/receptor"),
                casValidationFilter()));
        listOfFilterChains.add(new DefaultSecurityFilterChain(
                new AntPathRequestMatcher("/eRSPG/j_spring_security_logout"),
                logoutFilter(), etf(), fsi()));
        listOfFilterChains.add(new DefaultSecurityFilterChain(
                new AntPathRequestMatcher("/eRSPG/**"),
                authenticationFilter(), casValidationFilter(), wrappingFilter(), sif(),
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
        mUserDetailsByNameServiceWrapper.setUserDetailsService(userService());
        return mUserDetailsByNameServiceWrapper;
    }

    @Bean
    public CustomUserDetailsService userService(){
        // figure out how to set this up
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
        j2eePreAuthFilter.setAuthenticationManager(authenticationManager());
        j2eePreAuthFilter.setAuthenticationDetailsSource(authenticationDetailsSource());
        return j2eePreAuthFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        //figure out how to set this up
        AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(authenticationProvider()));
        return authenticationManager;
    }

    @Bean
    public CustomUserAuthenticationProvider authenticationProvider(){
        return new CustomUserAuthenticationProvider();
    }

    @Bean
    public WebAuthenticationDetailsSource authenticationDetailsSource(){
        return new WebAuthenticationDetailsSource();
    }

    @Bean
    public LogoutFilter logoutFilter(){
        LogoutFilter logoutFilter = new LogoutFilter("/", securityContextLogoutHandler());
        return logoutFilter;
    }

    @Bean
    public SecurityContextLogoutHandler securityContextLogoutHandler(){
        return new SecurityContextLogoutHandler();
    }

//    @Bean
//    public ServletContextAttributeFactoryBean servletContext(){
//        ServletContextAttributeFactoryBean servletContextAttributeFactoryBean = new ServletContextAttributeFactoryBean();
//        //List<String> attributes = (List<String>) getServletContext.getAttributeNames();
//        servletContextAttributeFactoryBean.setAttributeName("cas.root");
//        return servletContextAttributeFactoryBean;
//    }

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
        mFilterSecurityInterceptor.setAuthenticationManager(authenticationManager());
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
        //cofigure this stuff in here
            /*
            <property name="securityMetadataSource">
              <sec:filter-invocation-definition-source>
                <sec:intercept-url pattern="/secure/extreme/**" access="ROLE_SUPERVISOR"/>
                <sec:intercept-url pattern="/secure/**" access="ROLE_USER"/>
                <sec:intercept-url pattern="/**" access="ROLE_USER"/>
              </sec:filter-invocation-definition-source>
            </property>
            */
        //          This is how i will do it

        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();
        requestMap.put(new AntPathRequestMatcher("/eRSPG/**"), SecurityConfig.createList("hasRole('ROLE_USER')"));
        requestMap.put(new AntPathRequestMatcher("/eRSPG/admin/**"),SecurityConfig.createList("hasRole('ROLE_ADMIN')"));
        requestMap.put(new AntPathRequestMatcher("/eRSPG/chair/**"),SecurityConfig.createList("hasRole('ROLE_CHAIRMAN')"));
        FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, new DefaultWebSecurityExpressionHandler());
        return filterInvocationSecurityMetadataSource;
    }

    @Bean
    public RunAsManager runAsManager() throws Exception {
        RunAsManagerImpl runAsManager = new RunAsManagerImpl();
        runAsManager.setKey("ROLE_ADMIN");
        runAsManager.afterPropertiesSet();
        return runAsManager;
    }

    @Bean
    public SecurityContextHolderAwareRequestFilter securityContextHolderAwareRequestFilter(){
        return new SecurityContextHolderAwareRequestFilter();
    }

    @Bean
    public Cas20ServiceTicketValidator ticketValidator(){
        Cas20ServiceTicketValidator mCas20ServiceTicketValidator = new Cas20ServiceTicketValidator(Constants.CAS_URL_PREFIX);
        mCas20ServiceTicketValidator.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
        mCas20ServiceTicketValidator.setProxyCallbackUrl(Constants.CAS_SERVICE_URL);
        return mCas20ServiceTicketValidator;
    }

    @Bean
    public ProxyGrantingTicketStorageImpl proxyGrantingTicketStorage(){
        return new ProxyGrantingTicketStorageImpl();
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
    public Cas20ProxyReceivingTicketValidationFilter casValidationFilter(){
        Cas20ProxyReceivingTicketValidationFilter mCas20ProxyReceivingTicketValidationFilter = new Cas20ProxyReceivingTicketValidationFilter();
        //mCas20ProxyReceivingTicketValidationFilter.setServerName(Constants.CAS_SERVER);
        mCas20ProxyReceivingTicketValidationFilter.setService(Constants.CAS_SERVICE_URL);
        //mCas20ProxyReceivingTicketValidationFilter.setProxyReceptorUrl("/proxy/receptor");
        mCas20ProxyReceivingTicketValidationFilter.setUseSession(true);
        mCas20ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
        mCas20ProxyReceivingTicketValidationFilter.setExceptionOnValidationFailure(true);
        mCas20ProxyReceivingTicketValidationFilter.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
        mCas20ProxyReceivingTicketValidationFilter.setTicketValidator(cas20ProxyTicketValidator());
        return mCas20ProxyReceivingTicketValidationFilter;
    }

    @Bean
    public Cas20ProxyTicketValidator cas20ProxyTicketValidator(){
        return new Cas20ProxyTicketValidator(Constants.CAS_URL_PREFIX);
    }

    @Bean
    public HttpServletRequestWrapperFilter wrappingFilter(){
        return  new HttpServletRequestWrapperFilter();
    }


}
