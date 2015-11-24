package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for Semester model.
 */
public class SemesterTest {

    private Semester fixture;
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new Semester();
    }

    @Test
    public void testSemesterId() throws Exception {
        int id = 16;
        fixture.setSemesterId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getSemesterId());
    }

    @Test
    public void testSemesterName() throws Exception {
        String semester = "School's out for SUMMER!";
        fixture.setSemesterName(semester);

        assertNotNull(fixture);
        assertTrue(semester.equals(fixture.getSemesterName()));
    }
}