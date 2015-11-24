package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for User model.
 */
public class UserTest {
    
    private User fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new User();
    }

    @Test
    public void testUserId() throws Exception {
        int id = 256;
        fixture.setUserId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getUserId());
    }

    @Test
    public void testEmail() throws Exception {
        String email = "ballroomdancing@theranch.com";
        fixture.setEmail(email);

        assertNotNull(fixture);
        assertTrue(email.equals(fixture.getEmail()));
    }

    @Test
    public void testFirstName() throws Exception {
        String firstName = "Han";
        fixture.setFirstName(firstName);

        assertNotNull(fixture);
        assertTrue(firstName.equals(fixture.getFirstName()));
    }

    @Test
    public void testLastName() throws Exception {
        String lastName = "Solo";
        fixture.setLastName(lastName);

        assertNotNull(fixture);
        assertTrue(lastName.equals(fixture.getLastName()));
    }
}