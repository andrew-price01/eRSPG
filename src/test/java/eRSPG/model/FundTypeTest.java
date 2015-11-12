package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for FundType model.
 */
public class FundTypeTest {

    private FundType fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new FundType();
    }

    @Test
    public void testFundTypeId() throws Exception {
        int id = 2;
        fixture.setFundTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getFundTypeId());
    }

    @Test
    public void testFundTypeDesc() throws Exception {
        String description = "I'm a little teapot short and stout! Here is my handle, here is my spout!"
                + "When I get all worked up, I will shout! Tip me over and pour me out!";
        fixture.setFundTypeDesc(description);

        assertNotNull(fixture);
        assertTrue(description.equals(fixture.getFundTypeDesc()));
    }
}