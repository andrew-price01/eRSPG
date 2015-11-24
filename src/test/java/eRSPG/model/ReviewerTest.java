package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

/**
 * Unit tests for Reviewer model.
 */
public class ReviewerTest {

    private Reviewer fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new Reviewer();
    }

    @Test
    public void testReviewerId() throws Exception {
        int id = 42;
        fixture.setReviewerId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getReviewerId());
    }

    @Test
    public void testProposalId() throws Exception {
        int id = 1999;
        fixture.setProposalId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProposalId());
    }

    @Test
    public void testUserId() throws Exception {
        int id = 2000;
        fixture.setUserId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getUserId());
    }

    @Test
    public void testDepartmentId() throws Exception {
        int id = 2001;
        fixture.setDepartmentId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getDepartmentId());
    }

    @Test
    public void testReviewComment() throws Exception {
        String comment = "This is a very asfjdasfjlzcnjewro report.";
        fixture.setReviewComment(comment);

        assertNotNull(fixture);
        assertTrue(comment.equals(fixture.getReviewComment()));
    }

    @Test
    public void testUpdatedAt() throws Exception {
        LocalDateTime update = LocalDateTime.now();
        fixture.setUpdatedAt(update);

        assertNotNull(fixture);
        assertTrue(update.isEqual(fixture.getUpdatedAt()));
    }
}