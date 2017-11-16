package eRSPG.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.util.EnumSet;

public class ERSPGWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    private final Logger log = LoggerFactory.getLogger(ERSPGWebAppInitializer.class);

    @Override
    protected String[] getServletMappings()
    {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {};
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        super.registerDispatcherServlet(servletContext);
        servletContext.addListener(new SingleSignOutHttpSessionListener());
        //servletContext.addListener(new ContextLoaderListener());
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("webAppRootKey", "cas.root");

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR);

        // NOT SURE WHY THIS ISNT WORKING ... Keeps saying cas server url prefix cant be null but it's obviously set...FML
//        FilterRegistration.Dynamic ssoFilter = servletContext.addFilter("CAS Single Sign Out Filter", singleSignOutFilter());
//        ssoFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/eRSPG/*");

        FilterRegistration.Dynamic springSecurityFilter = servletContext.addFilter("Spring Security Filter", delegatingFilterProxySpringSecurity());
        springSecurityFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/eRSPG/*");


//        FilterRegistration.Dynamic validFilter = servletContext.addFilter("CAS Validation Filter", delegatingFilterProxyValidation());
//        validFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/eRSPG/*");
//
//        FilterRegistration.Dynamic authFilter = servletContext.addFilter("CAS Authentication Filter", delegatingFilterProxyAuthenitication());
//        authFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/eRSPG/*");
    }


    public SingleSignOutFilter singleSignOutFilter(){
        SingleSignOutFilter mSingleSignOutFilter = new SingleSignOutFilter();
        mSingleSignOutFilter.setCasServerUrlPrefix(Constants.CAS_URL_PREFIX);
        return mSingleSignOutFilter;
    }

    public DelegatingFilterProxy delegatingFilterProxyAuthenitication() {
        DelegatingFilterProxy mDelegatingFilterProxy = new DelegatingFilterProxy();
        mDelegatingFilterProxy.setTargetBeanName("authenticationFilter");
        return mDelegatingFilterProxy;
    }

    public DelegatingFilterProxy delegatingFilterProxyValidation() {
        DelegatingFilterProxy mDelegatingFilterProxy = new DelegatingFilterProxy();
        mDelegatingFilterProxy.setTargetBeanName("cas10TicketValidationFilter");
        return mDelegatingFilterProxy;
    }

    public DelegatingFilterProxy delegatingFilterProxySpringSecurity() {
        DelegatingFilterProxy mDelegatingFilterProxy = new DelegatingFilterProxy();
        mDelegatingFilterProxy.setTargetBeanName("springSecurityFilterChain");
        return mDelegatingFilterProxy;
    }

}
