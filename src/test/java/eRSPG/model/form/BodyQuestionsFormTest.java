package eRSPG.model.form;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for BodyQuestionsForm model.
 */
public class BodyQuestionsFormTest {

    private BodyQuestionsForm fixture;
    private static final String text = "This is a testable line of text.";

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new BodyQuestionsForm();
    }

    @Test
    public void testGetQ1() throws Exception {
        fixture.setQ1(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ1()));
    }

    @Test
    public void testGetQ2() throws Exception {
        fixture.setQ2(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ2()));
    }

    @Test
    public void testGetQ3() throws Exception {
        fixture.setQ3(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ3()));
    }

    @Test
    public void testGetQ4() throws Exception {
        fixture.setQ4(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ4()));
    }

    @Test
    public void testGetQ5() throws Exception {
        fixture.setQ5(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ5()));
    }

    @Test
    public void testGetQ6() throws Exception {
        fixture.setQ6(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ6()));
    }

    @Test
    public void testGetQ7() throws Exception {
        fixture.setQ7(text);

        assertNotNull(fixture);
        assertTrue(text.equals(fixture.getQ7()));
    }
}