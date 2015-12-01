package eRSPG.model.form;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for BodyForm model.
 */
public class BodyFormTest {

    private BodyForm fixture;
    private static final String text = "This is a testable line of text.";

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new BodyForm();
    }

    @Test
    public void testSummary() throws Exception {
        fixture.setSummary(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getSummary()));
    }

    @Test
    public void testBackground() throws Exception {
        fixture.setBackground(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getBackground()));
    }

    @Test
    public void testHemmingwayExcellence() throws Exception {
        fixture.setHemmingwayExcellence(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getHemmingwayExcellence()));
    }

    @Test
    public void testHemmingwayCollaboration() throws Exception {
        fixture.setHemmingwayCollaboration(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getHemmingwayCollaboration()));
    }
}