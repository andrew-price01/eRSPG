package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for Fund model.
 */
public class FundTest {

    private Fund fixture;
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new Fund();
    }

    @Test
    public void testFundId() throws Exception {
        int id = 9001;
        fixture.setFundId(id);
        
        assertNotNull(fixture);
        assertEquals(id, fixture.getFundId());
    }

    @Test
    public void testProposalId() throws Exception {
        int id = 21;
        fixture.setProposalId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProposalId());
    }

    @Test
    public void testFundTypeId() throws Exception {
        int id = 25;
        fixture.setFundTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getFundTypeId());
    }

    @Test
    public void testSourceTypeId() throws Exception {
        int id = 128;
        fixture.setSourceTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getSourceTypeId());
    }

    @Test
    public void testFundCategoryId() throws Exception {
        int id = 5;
        fixture.setFundCategoryId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getFundCategoryId());
    }

    @Test
    public void testFundAmount() throws Exception {
        double amount = 3.14159;
        fixture.setFundAmount(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getFundAmount());
    }

    @Test
    public void testComments() throws Exception {
        String comment = "'Tis but a flesh wound.";
        fixture.setComments(comment);

        assertNotNull(comment);
        assertTrue(comment.equals(fixture.getComments()));
    }
}