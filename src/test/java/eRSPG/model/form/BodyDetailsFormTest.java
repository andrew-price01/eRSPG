package eRSPG.model.form;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for BodyDetailsForm model.
 */
public class BodyDetailsFormTest {
    
    private BodyDetailsForm fixture;
    private String text = "This is a testable line of text.";

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new BodyDetailsForm();
    }

    @Test
    public void testProcedures() throws Exception {
        fixture.setProcedures(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getProcedures()));
    }

    @Test
    public void testTimeLine() throws Exception {
        fixture.setTimeLine(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getTimeLine()));
    }

    @Test
    public void testEvaluation() throws Exception {
        fixture.setEvaluation(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getEvaluation()));
    }

    @Test
    public void testBudgetNarrative() throws Exception {
        fixture.setBudgetNarrative(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getBudgetNarrative()));
    }
}