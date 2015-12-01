package eRSPG.model.form;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for DetailFormTest model.
 */
public class DetailFormTest {

    private DetailForm fixture;
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new DetailForm();
    }

    @Test
    public void testProposalTitle() throws Exception {
        String title = "Super Great Title for a Project";
        fixture.setProposalTitle(title);

        assertNotNull(fixture);
        assertTrue(title.equals(fixture.getProposalTitle()));
    }

    @Test
    public void testProposalEmail() throws Exception {
        String email = "best_email_evar@winning.com";
        fixture.setProposalEmail(email);

        assertNotNull(fixture);
        assertTrue(email.equals(fixture.getProposalEmail()));
    }

    @Test
    public void testProposalMailCode() throws Exception {
        String mailCode = "189410";
        fixture.setProposalMailCode(mailCode);

        assertNotNull(fixture);
        assertTrue(mailCode.equals(fixture.getProposalMailCode()));
    }

    @Test
    public void testProposalExtension() throws Exception {
        String ext = "404";
        fixture.setProposalExtension(ext);

        assertNotNull(fixture);
        assertTrue(ext.equals(fixture.getProposalExtension()));
    }

    @Test
    public void testProjectDirector() throws Exception {
        String director = "Mr. Big Boss Man";
        fixture.setProjectDirector(director);

        assertNotNull(fixture);
        assertTrue(director.equals(fixture.getProjectDirector()));
    }
}