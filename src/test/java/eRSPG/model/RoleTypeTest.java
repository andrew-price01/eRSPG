package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for RoleType model.
 */
public class RoleTypeTest {

    private RoleType fixture;
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new RoleType();
    }

    @Test
    public void testRoleTypeId() throws Exception {
        int id = 8;
        fixture.setRoleTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getRoleTypeId());
    }

    @Test
    public void testRoleDesc() throws Exception {
        String role = "Avenger";
        fixture.setRoleDesc(role);

        assertNotNull(fixture);
        assertTrue(role.equals(fixture.getRoleDesc()));
    }
}