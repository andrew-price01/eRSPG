package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for Department DTO.
 */
public class DepartmentTest {

    public Department fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new Department();
    }

    @Test
    public void testDepartmentId() throws Exception {
        int id = 777;
        fixture.setDepartmentId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getDepartmentId());
    }

    @Test
    public void testGetDepartmentName() throws Exception {
        String name = "Computer Science";
        fixture.setDepartmentName(name);

        assertNotNull(fixture);
        assertTrue(name.equals(fixture.getDepartmentName()));
    }
}