package eRSPG.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
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
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        servletContext.setInitParameter("webAppRootKey", "cas.root");

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR);
    }

}
