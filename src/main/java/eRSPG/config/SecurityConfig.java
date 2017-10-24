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

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private static final String CAS_URL_LOGIN = "https://localhost:8443/cas/login";
    private static final String CAS_URL_LOGOUT = "https://localhost:8443/cas/logout";
    private static final String CAS_URL_PREFIX = "https://localhost:8443/cas";
    private static final String CAS_SERVICE_URL = "https://localhost:8443/cas/p3/serviceValidate";
    private static final String APP_SERVER = "https://localhost:8080";


//    @Bean
//    public ServiceProperties serviceProperties() {
//        ServiceProperties mServiceProperties = new ServiceProperties();
//        mServiceProperties.setService(CAS_SERVICE_URL);
//        mServiceProperties.setSendRenew(false);
//        return mServiceProperties;
//    }

//    @Bean
//    public FilterRegistrationBean CasAuthenticationFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(delegatingFilterProxy());
//        registration.addUrlPatterns("/eRSPG/*");
//        registration.setName("CAS Authentication Filter");
//        registration.setOrder(1);
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean CasValidationFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(cas30ProxyReceivingTicketValidationFilter());
//        registration.addUrlPatterns("/eRSPG/*");
//        registration.setName("CAS Validation Filter");
//        registration.setOrder(2);
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean CasHttpServletRequestWrapperFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(httpServletRequestWrapperFilter());
//        registration.addUrlPatterns("/eRSPG/*");
//        registration.setName("CAS HttpServletRequest Wrapper Filter");
//        registration.setOrder(3) ;
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean CasSingleSignOutFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(singleSignOutFilter());
//        registration.addUrlPatterns("/eRSPG/*");
//        registration.setName("CAS SingleSignOut Filter");
//        registration.setOrder(4) ;
//        return registration;
//    }

//    @Bean
//    public SingleSignOutFilter singleSignOutFilter(){
//        SingleSignOutFilter mSingleSignOutFilter = new SingleSignOutFilter();
//        mSingleSignOutFilter.setCasServerUrlPrefix(CAS_URL_PREFIX);
//        return mSingleSignOutFilter;
//    }
//
//    @Bean
//    public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener(){
//        return new SingleSignOutHttpSessionListener();
//    }
//
//    @Bean
//    public DelegatingFilterProxy delegatingFilterProxy() {
//        DelegatingFilterProxy mDelegatingFilterProxy = new DelegatingFilterProxy();
//        mDelegatingFilterProxy.setTargetBeanName("authenticationFilter");
//        return mDelegatingFilterProxy;
//    }
//
//
//    @Bean
//    public AuthenticationFilter authenticationFilter(){
//        AuthenticationFilter mAuthenticationFilter = new AuthenticationFilter();
//        mAuthenticationFilter.setCasServerLoginUrl(CAS_URL_LOGIN);
//        mAuthenticationFilter.setRenew(false);
//        mAuthenticationFilter.setGateway(false);
//        mAuthenticationFilter.setServerName(APP_SERVER);
//        mAuthenticationFilter.setService(CAS_SERVICE_URL);
//        return mAuthenticationFilter;
//    }
//
//    @Bean
//    public HttpServletRequestWrapperFilter httpServletRequestWrapperFilter(){
//        return new HttpServletRequestWrapperFilter();
//    }

//    @Bean
//    public Cas10TicketValidationFilter cas10TicketValidationFilter(){
//        Cas10TicketValidationFilter mCas10TicketValidationFilter = new Cas10TicketValidationFilter();
//        mCas10TicketValidationFilter.setService(CAS_SERVICE_URL);
//        mCas10TicketValidationFilter.setTicketValidator(cas10TicketValidator());
//        return mCas10TicketValidationFilter;
//    }
//
//    @Bean
//    public Cas10TicketValidator cas10TicketValidator(){
//        return  new Cas10TicketValidator(CAS_URL_PREFIX);
//    }

//    @Bean
//    public Saml11TicketValidationFilter saml11TicketValidationFilter(){
//        Saml11TicketValidationFilter mSaml11TicketValidationFilter = new Saml11TicketValidationFilter();
//        mSaml11TicketValidationFilter.setService(CAS_SERVICE_URL);
//        mSaml11TicketValidationFilter.setTicketValidator(saml11TicketValidator());
//        return mSaml11TicketValidationFilter;
//    }
//
//    @Bean
//    public Saml11TicketValidator saml11TicketValidator(){
//        return  new Saml11TicketValidator(CAS_URL_PREFIX);
//    }

//    @Bean
//    public Cas20ProxyReceivingTicketValidationFilter cas20ProxyReceivingTicketValidationFilter(){
//        Cas20ProxyReceivingTicketValidationFilter mCas20ProxyReceivingTicketValidationFilter = new Cas20ProxyReceivingTicketValidationFilter();
//        mCas20ProxyReceivingTicketValidationFilter.setServerName(APP_SERVICE_HOME);
//        mCas20ProxyReceivingTicketValidationFilter.setService(CAS_SERVICE_URL);
//        mCas20ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
//        mCas20ProxyReceivingTicketValidationFilter.setTicketValidator(cas20ProxyTicketValidator());
//        return mCas20ProxyReceivingTicketValidationFilter;
//    }
//
//    @Bean
//    public Cas20ProxyTicketValidator cas20ProxyTicketValidator(){
//        return new Cas20ProxyTicketValidator(CAS_URL_PREFIX);
//    }

//    @Bean
//    public Cas30ProxyReceivingTicketValidationFilter cas30ProxyReceivingTicketValidationFilter(){
//        Cas30ProxyReceivingTicketValidationFilter mCas30ProxyReceivingTicketValidationFilter = new Cas30ProxyReceivingTicketValidationFilter();
//        mCas30ProxyReceivingTicketValidationFilter.setServerName(APP_SERVER);
//        //mCas30ProxyReceivingTicketValidationFilter.setService(CAS_SERVICE_URL);
//        mCas30ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
//        mCas30ProxyReceivingTicketValidationFilter.setUseSession(true);
//        mCas30ProxyReceivingTicketValidationFilter.setTicketValidator(cas30ProxyTicketValidator());
//        return mCas30ProxyReceivingTicketValidationFilter;
//    }
//
//    @Bean
//    public Cas30ProxyTicketValidator cas30ProxyTicketValidator(){
//        return new Cas30ProxyTicketValidator(CAS_URL_PREFIX);
//    }

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
