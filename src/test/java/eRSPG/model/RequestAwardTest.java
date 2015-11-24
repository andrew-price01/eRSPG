package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for RequestAward model.
 */
public class RequestAwardTest {

    private RequestAward fixture;
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new RequestAward();
    }

    @Test
    public void testRequestAwardId() throws Exception {
        int id = 1;
        fixture.setRequestAwardId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getRequestAwardId());
    }

    @Test
    public void testAwardTypeId() throws Exception {
        int id = 7;
        fixture.setAwardTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getAwardTypeId());
    }

    @Test
    public void testProposalId() throws Exception {
        int id = 12;
        fixture.setProposalId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProposalId());
    }
}