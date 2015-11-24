package eRSPG.model.form;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Unit tests for AwardTypeForm model.
 */
public class AwardTypeFormTest {
    
    private AwardTypeForm fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new AwardTypeForm();
    }

    @Test
    public void testProjectTypeID() throws Exception {
        int id = 2048;
        fixture.setProjectTypeID(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProjectTypeID());
    }

    @Test
    public void testAwardTypes() throws Exception {
        List<Integer> awards = new ArrayList<>(3);
        awards.add(7);
        awards.add(33);
        awards.add(92);
        fixture.setAwardTypes(awards);

        assertNotNull(fixture);

        for (int i = 0; i < awards.size() || i <fixture.getAwardTypes().size(); i++) {
            assertEquals(awards.get(i), fixture.getAwardTypes().get(i));
        }
    }
}