package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit testing for the Awarded model.
 */
public class AwardedTest {

    private Awarded fixture;
    
    @BeforeMethod
    public void SetUp() throws Exception {
        fixture = new Awarded();
    }
    
    @Test
    public void testAwardedId() throws Exception {
        int id = 7;
        fixture.setAwardedId(id);
        
        assertNotNull(fixture);
        assertEquals(id, fixture.getAwardedId());
    }

    @Test
    public void testProposalId() throws Exception {
        int proposalId = 60;
        fixture.setProposalId(proposalId);
        
        assertNotNull(fixture);
        assertEquals(proposalId, fixture.getProposalId());
    }

    @Test
    public void testAwardedAmount() throws Exception {
        double amount = 5000.0;
        fixture.setAwardedAmount(amount);
        
        assertNotNull(fixture);
        assertEquals(amount, fixture.getAwardedAmount());
    }

    @Test
    public void testAwardedTypeId() throws Exception {
        int typeId = 1;
        fixture.setAwardedTypeId(typeId);

        assertNotNull(fixture);
        assertEquals(typeId, fixture.getAwardedTypeId());
    }
}