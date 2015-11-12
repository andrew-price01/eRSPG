package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

/**
 * Unit tests for Proposal model.
 */
public class ProposalTest {

    private Proposal fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new Proposal();
    }

    @Test
    public void testProposalId() throws Exception {
        int id = 1;
        fixture.setProposalId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProposalId());
    }

    @Test
    public void testProposalTitle() throws Exception {
        String title = "Title of the Song: Naive Expression of Love";
        fixture.setProposalTitle(title);

        assertNotNull(fixture);
        assertTrue(title.equals(fixture.getProposalTitle()));
    }

    @Test
    public void testSemesterId() throws Exception {
        int id = 2;
        fixture.setSemesterId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getSemesterId());
    }

    @Test
    public void testProposalYear() throws Exception {
        int year = 2015;
        fixture.setProposalYear(year);

        assertNotNull(fixture);
        assertEquals(year, fixture.getProposalYear());
    }

    @Test
    public void testProjectTypeId() throws Exception {
        int id = 4;
        fixture.setProjectTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProjectTypeId());
    }

    @Test
    public void testSubmissionDate() throws Exception {
        LocalDateTime date = LocalDateTime.now();
        fixture.setSubmissionDate(date);

        assertNotNull(fixture);
        assertTrue(date.isEqual(fixture.getSubmissionDate()));
    }

    @Test
    public void testProjectDirector() throws Exception {
        String director = "Head Honcho";
        fixture.setProjectDirector(director);

        assertNotNull(fixture);
        assertTrue(director.equals(fixture.getProjectDirector()));
    }

    @Test
    public void testDepartmentId() throws Exception {
        int id = 5;
        fixture.setDepartmentId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getDepartmentId());
    }

    @Test
    public void testProposalEmail() throws Exception {
        String email = "sudo@linuxkernel.org";
        fixture.setProposalEmail(email);

        assertNotNull(fixture.getProposalEmail());
        assertTrue(email.equals(fixture.getProposalEmail()));
    }

    @Test
    public void testProposalMailCode() throws Exception {
        String code = "84040";
        fixture.setProposalMailCode(code);

        assertNotNull(fixture);
        assertTrue(code.equals(fixture.getProposalMailCode()));
    }

    @Test
    public void testProposalExtension() throws Exception {
        String extension = "ID10T";
        fixture.setProposalExtension(extension);

        assertNotNull(fixture);
        assertTrue(extension.equals(fixture.getProposalExtension()));
    }

    @Test
    public void testProposalReqStdAsst() throws Exception {
        fixture.setProposalReqStdAsst(true);

        assertNotNull(fixture);
        assertTrue(fixture.isProposalReqStdAsst());
    }

    @Test
    public void testProposalComplete() throws Exception {
        fixture.setProposalComplete(false);

        assertNotNull(fixture);
        assertFalse(fixture.isProposalComplete());
    }

    @Test
    public void testUpdatedDate() throws Exception {
        LocalDateTime date = LocalDateTime.now();
        fixture.setUpdatedDate(date);

        assertNotNull(fixture);
        assertTrue(date.isEqual(fixture.getUpdatedDate()));
    }
}