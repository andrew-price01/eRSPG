package eRSPG;

import org.springframework.context.ApplicationContext;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.ServletContext;

import static org.testng.Assert.*;

/**
 * Unit testing for the WebConfig.
 */
public class WebConfigTest {

    private WebConfig fixture;

    @BeforeMethod
    public void SetUp() throws Exception {
        fixture = new WebConfig();
    }

    @Test
    public void testAddResourceHandlers() throws Exception {
        ApplicationContext appContext = new org.springframework.mock.jndi.SimpleNamingContextBuilder();
        ServletContext servletContext =

        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(appContext);
        fixture.addResourceHandlers(registry);

        assertTrue(registry.hasMappingForPattern("css/**"));
        assertTrue(registry.hasMappingForPattern("js/**"));
        assertTrue(registry.hasMappingForPattern("img/**"));
        assertTrue(registry.hasMappingForPattern("font/**"));
    }
}