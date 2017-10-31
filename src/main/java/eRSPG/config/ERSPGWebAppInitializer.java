package eRSPG.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.util.EnumSet;

public class ERSPGWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {



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
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR);

        FilterRegistration.Dynamic validFilter = servletContext.addFilter("CAS Validation Filter", delegatingFilterProxyValidation());
        validFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/eRSPG/*");

        FilterRegistration.Dynamic authFilter = servletContext.addFilter("CAS Authentication Filter", delegatingFilterProxyAuthenitication());
        authFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/eRSPG/*");

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

    public HttpServletRequestWrapperFilter httpServletRequestWrapperFilter(){
        return new HttpServletRequestWrapperFilter();
    }

    public AssertionThreadLocalFilter assertionThreadLocalFilter(){
        AssertionThreadLocalFilter mAssertionThreadLocalFilter = new AssertionThreadLocalFilter();
        return new AssertionThreadLocalFilter();
    }
}
