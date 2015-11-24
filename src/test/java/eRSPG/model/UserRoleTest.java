package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

/**
 * Unit tests for UserRole model.
 */
public class UserRoleTest {
    
    private UserRole fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new UserRole();
    }

    @Test
    public void testUserRoleId() throws Exception {
        int id = 256;
        fixture.setUserRoleId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getUserRoleId());
    }

    @Test
    public void testUserId() throws Exception {
        int id = 512;
        fixture.setUserId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getUserId());
    }

    @Test
    public void testRoleTypeId() throws Exception {
        int id = 1024;
        fixture.setRoleTypeId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getRoleTypeId());
    }

    @Test
    public void testRevoked() throws Exception {
        LocalDateTime date = LocalDateTime.now();
        fixture.setRevoked(date);

        assertNotNull(fixture);
        assertTrue(date.isEqual(fixture.getRevoked()));
    }

    @Test
    public void testUpdatedAt() throws Exception {
        LocalDateTime date = LocalDateTime.now();
        fixture.setUpdatedAt(date);

        assertNotNull(fixture);
        assertTrue(date.isEqual(fixture.getUpdatedAt()));
    }
}