package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test for FundCategory model.
 */
public class FundCategoryTest {

    public FundCategory fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new FundCategory();
    }

    @Test
    public void testGetFundCategoryId() throws Exception {
        int id = 10;
        fixture.setFundCategoryId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getFundCategoryId());
    }

    @Test
    public void testGetFundCategoryDesc() throws Exception {
        String description = "I'm a watermelon!";
        fixture.setFundCategoryDesc(description);

        assertNotNull(fixture);
        assertTrue(description.equals(fixture.getFundCategoryDesc()));
    }
}