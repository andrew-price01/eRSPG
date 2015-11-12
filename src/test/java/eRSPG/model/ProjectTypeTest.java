package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for ProjectType model.
 */
public class ProjectTypeTest {

    private ProjectType fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new ProjectType();
    }

    @Test
    public void testProjectTypeID() throws Exception {
        int id = 32;
        fixture.setProjectTypeID(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProjectTypeID());
    }

    @Test
    public void testProjectTypeName() throws Exception {
        String name = "NoSQL Extraordinaire";
        fixture.setProjectTypeName(name);

        assertNotNull(fixture);
        assertTrue(name.equals(fixture.getProjectTypeName()));
    }
}