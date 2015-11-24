package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for SourceType model.
 */
public class SourceTypeTest {

    private SourceType fixture;
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new SourceType();
    }

    @Test
    public void testSourceTypeId() throws Exception {
        int id = 32;
        fixture.setSourceTypeId(id);
        
        assertNotNull(fixture);
        assertEquals(id, fixture.getSourceTypeId());
    }

    @Test
    public void testSourceTypeDesc() throws Exception {
        String description = "The Library of Congress";
        fixture.setSourceTypeDesc(description);

        assertNotNull(fixture);
        assertTrue(description.equals(fixture.getSourceTypeDesc()));
    }
}