package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for ParticipantTest model.
 */
public class ParticipantTest {

    private Participant fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new Participant();
    }

    @Test
    public void testParticipantId() throws Exception {
        int id = 8;
        fixture.setParticipantId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getParticipantId());
    }

    @Test
    public void testProjectId() throws Exception {
        int id = 16;
        fixture.setProjectId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProjectId());
    }

    @Test
    public void testFirstName() throws Exception {
        String firstName = "Abraham";
        fixture.setFirstName(firstName);

        assertNotNull(fixture);
        assertTrue(firstName.equals(fixture.getFirstName()));
    }

    @Test
    public void testLastName() throws Exception {
        String lastName = "Lincon";
        fixture.setLastName(lastName);

        assertNotNull(fixture);
        assertTrue(lastName.equals(fixture.getLastName()));
    }

    @Test
    public void testProposalId() throws Exception {
        int id = 32;
        fixture.setProposalId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProposalId());
    }
}