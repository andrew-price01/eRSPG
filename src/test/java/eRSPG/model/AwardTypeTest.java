package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit testing for AwardType DTO.
 */
public class AwardTypeTest {

    private AwardType fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new AwardType();
    }

    @Test
    public void testAwardTypeId() throws Exception {
        int typeId = 3;
        fixture.setAwardTypeId(typeId);

        assertNotNull(fixture);
        assertEquals(typeId, fixture.getAwardTypeId());
    }

    @Test
    public void testAwardName() throws Exception {
        String name = "Hemmingway Fund";
        fixture.setAwardName(name);

        assertNotNull(fixture);
        assertTrue(name.equals(fixture.getAwardName()));
    }
}