package eRSPG.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInitializer implements ServletContextInitializer {

    private static final String CAS_URL_LOGIN = "https://localhost:8443/cas/login";
    private static final String CAS_URL_LOGOUT = "https://localhost:8443/cas/logout";
    private static final String CAS_URL_PREFIX = "https://localhost:8443/cas";
    private static final String CAS_SERVICE_URL = "https://localhost:8443/cas/p3/serviceValidate";
    private static final String APP_SERVER = "https://localhost:8080";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        FilterRegistration.Dynamic casDelegatingFilterProxyRegistration = servletContext.addFilter("CAS Delagate Filter", DelegatingFilterProxy.class);
//        casDelegatingFilterProxyRegistration.setInitParameter("authenticationFilter", "authenticationFilter");
//        casDelegatingFilterProxyRegistration.addMappingForUrlPatterns(null, false, "/eRSPG/*");


//        FilterRegistration.Dynamic casAuthenticationFilterRegistration = servletContext.addFilter("CAS Authenication Filter", AuthenticationFilter.class);
//        casAuthenticationFilterRegistration.setInitParameter("casServerLoginUrl", CAS_URL_LOGIN);
//        casAuthenticationFilterRegistration.setInitParameter("serverName", APP_SERVER);
//        casAuthenticationFilterRegistration.setInitParameter("encoding", "UTF-8");
//        casAuthenticationFilterRegistration.addMappingForUrlPatterns(null, false, "/eRSPG/*");

//        FilterRegistration.Dynamic casValidationFilterRegistration = servletContext.addFilter("CAS Validation Filter", Cas30ProxyReceivingTicketValidationFilter.class);
//        casValidationFilterRegistration.setInitParameter("casServerUrlPrefix", CAS_URL_PREFIX);
//        casValidationFilterRegistration.setInitParameter("serverName", APP_SERVER);
//        casValidationFilterRegistration.setInitParameter("redirectAfterValidation", "true");
//        casValidationFilterRegistration.addMappingForUrlPatterns(null, false, "/eRSPG/*");
//
//        FilterRegistration.Dynamic casHttpServletRequestWrapperFilterRegistration = servletContext.addFilter("CAS HttpServletRequest Wrapper Filter", HttpServletRequestWrapperFilter.class);
//        casHttpServletRequestWrapperFilterRegistration.addMappingForUrlPatterns(null, false, "/eRSPG/*");
    }

//    @Bean
//    public AuthenticationFilter authenticationFilter(){
//        AuthenticationFilter mAuthenticationFilter = new AuthenticationFilter();
//        mAuthenticationFilter.setCasServerLoginUrl(CAS_URL_LOGIN);
//        mAuthenticationFilter.setRenew(false);
//        mAuthenticationFilter.setGateway(false);
//        mAuthenticationFilter.setService(CAS_SERVICE_URL);
//        return mAuthenticationFilter;
//    }
}
