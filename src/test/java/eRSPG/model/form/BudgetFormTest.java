package eRSPG.model.form;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for BudgetForm model.
 */
public class BudgetFormTest {

    private BudgetForm fixture;
    private static final String answer = "This is some text.";
    private static final double amount = 60.75;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new BudgetForm();
    }

    @Test
    public void testStudentAssistants() throws Exception {
        fixture.setStudentAssistants(false);
        
        assertNotNull(fixture);
        assertFalse(fixture.getStudentAssistants());
    }

    @Test
    public void testA1() throws Exception {
        fixture.setA1(answer);
        
        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getA1()));
    }

    @Test
    public void testA2() throws Exception {
        fixture.setA2(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getA2()));
    }

    @Test
    public void testA3() throws Exception {
        fixture.setA3(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getA3()));
    }

    @Test
    public void testA4() throws Exception {
        fixture.setA4(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getA4()));
    }

    @Test
    public void testaBen() throws Exception {
        fixture.setaBen(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getaBen()));
    }

    @Test
    public void testB1() throws Exception {
        fixture.setB1(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getB1()));
    }

    @Test
    public void testB2() throws Exception {
        fixture.setB2(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getB2()));
    }

    @Test
    public void testB3() throws Exception {
        fixture.setB3(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getB3()));
    }

    @Test
    public void testB4() throws Exception {
        fixture.setB4(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getB4()));
    }

    @Test
    public void testbBen() throws Exception {
        fixture.setbBen(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getbBen()));
    }

    @Test
    public void testC1() throws Exception {
        fixture.setC1(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getC1()));
    }

    @Test
    public void testC2() throws Exception {
        fixture.setC2(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getC2()));
    }

    @Test
    public void testC3() throws Exception {
        fixture.setC3(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getC3()));
    }

    @Test
    public void testC4() throws Exception {
        fixture.setC4(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getC4()));
    }

    @Test
    public void testcBen() throws Exception {
        fixture.setcBen(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getcBen()));
    }

    @Test
    public void testSource1_a_1() throws Exception {
        fixture.setSource1_a_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_a_1());
    }

    @Test
    public void testSource2_a_1() throws Exception {
        fixture.setSource2_a_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_a_1());
    }

    @Test
    public void testSource3_a_1() throws Exception {
        fixture.setSource3_a_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_a_1());
    }

    @Test
    public void testRequested_a_1() throws Exception {
        fixture.setRequested_a_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_a_1());
    }

    @Test
    public void testSource1_b_1() throws Exception {
        fixture.setSource1_b_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_b_1());
    }

    @Test
    public void testSource2_b_1() throws Exception {
        fixture.setSource2_b_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_b_1());
    }

    @Test
    public void testSource3_b_1() throws Exception {
        fixture.setSource3_b_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_b_1());
    }

    @Test
    public void testRequested_b_1() throws Exception {
        fixture.setRequested_b_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_b_1());
    }

    @Test
    public void testSource1_c_1() throws Exception {
        fixture.setSource1_c_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_c_1());
    }

    @Test
    public void testSource2_c_1() throws Exception {
        fixture.setSource2_c_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_c_1());
    }

    @Test
    public void testSource3_c_1() throws Exception {
        fixture.setSource3_c_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_c_1());
    }

    @Test
    public void testRequested_c_1() throws Exception {
        fixture.setRequested_c_1(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_c_1());
    }

    @Test
    public void testSource1_a_ben() throws Exception {
        fixture.setSource1_a_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_a_ben());
    }

    @Test
    public void testSource2_a_ben() throws Exception {
        fixture.setSource2_a_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_a_ben());
    }

    @Test
    public void testSource3_a_ben() throws Exception {
        fixture.setSource3_a_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_a_ben());
    }

    @Test
    public void testRequested_a_ben() throws Exception {
        fixture.setRequested_a_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_a_ben());
    }

    @Test
    public void testSource1_b_ben() throws Exception {
        fixture.setSource1_b_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_b_ben());
    }

    @Test
    public void testSource2_b_ben() throws Exception {
        fixture.setSource2_b_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_b_ben());
    }

    @Test
    public void testSource3_b_ben() throws Exception {
        fixture.setSource3_b_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_b_ben());
    }

    @Test
    public void testRequested_b_ben() throws Exception {
        fixture.setRequested_b_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_b_ben());
    }

    @Test
    public void testSource1_c_ben() throws Exception {
        fixture.setSource1_c_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_c_ben());
    }

    @Test
    public void testSource2_c_ben() throws Exception {
        fixture.setSource2_c_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_c_ben());
    }

    @Test
    public void testSource3_c_ben() throws Exception {
        fixture.setSource3_c_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_c_ben());
    }

    @Test
    public void testRequested_c_ben() throws Exception {
        fixture.setRequested_c_ben(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_c_ben());
    }

    @Test
    public void testSource1_a_2() throws Exception {
        fixture.setSource1_a_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_a_2());
    }

    @Test
    public void testSource2_a_2() throws Exception {
        fixture.setSource2_a_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_a_2());
    }

    @Test
    public void testSource3_a_2() throws Exception {
        fixture.setSource3_a_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_a_2());
    }

    @Test
    public void testRequested_a_2() throws Exception {
        fixture.setRequested_a_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_a_2());
    }

    @Test
    public void testSource1_b_2() throws Exception {
        fixture.setSource1_b_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_b_2());
    }

    @Test
    public void testSource2_b_2() throws Exception {
        fixture.setSource2_b_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_b_2());
    }

    @Test
    public void testSource3_b_2() throws Exception {
        fixture.setSource3_b_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_b_2());
    }

    @Test
    public void testRequested_b_2() throws Exception {
        fixture.setRequested_b_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_b_2());
    }

    @Test
    public void testSource1_c_2() throws Exception {
        fixture.setSource1_c_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_c_2());
    }

    @Test
    public void testSource2_c_2() throws Exception {
        fixture.setSource2_c_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_c_2());
    }

    @Test
    public void testSource3_c_2() throws Exception {
        fixture.setSource3_c_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_c_2());
    }

    @Test
    public void testRequested_c_2() throws Exception {
        fixture.setRequested_c_2(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_c_2());
    }

    @Test
    public void testSource1_a_3() throws Exception {
        fixture.setSource1_a_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_a_3());
    }

    @Test
    public void testSource2_a_3() throws Exception {
        fixture.setSource2_a_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_a_3());
    }

    @Test
    public void testSource3_a_3() throws Exception {
        fixture.setSource3_a_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_a_3());
    }

    @Test
    public void testRequested_a_3() throws Exception {
        fixture.setRequested_a_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_a_3());
    }

    @Test
    public void testSource1_b_3() throws Exception {
        fixture.setSource1_b_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_b_3());
    }

    @Test
    public void testSource2_b_3() throws Exception {
        fixture.setSource2_b_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_b_3());
    }

    @Test
    public void testSource3_b_3() throws Exception {
        fixture.setSource3_b_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_b_3());
    }

    @Test
    public void testRequested_b_3() throws Exception {
        fixture.setRequested_b_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_b_3());
    }

    @Test
    public void testSource1_c_3() throws Exception {
        fixture.setSource1_c_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_c_3());
    }

    @Test
    public void testSource2_c_3() throws Exception {
        fixture.setSource2_c_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_c_3());
    }

    @Test
    public void testSource3_c_3() throws Exception {
        fixture.setSource3_c_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_c_3());
    }

    @Test
    public void testRequested_c_3() throws Exception {
        fixture.setRequested_c_3(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_c_3());
    }

    @Test
    public void testSource1_a_4() throws Exception {
        fixture.setSource1_a_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_a_4());
    }

    @Test
    public void testSource2_a_4() throws Exception {
        fixture.setSource2_a_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_a_4());
    }

    @Test
    public void testSource3_a_4() throws Exception {
        fixture.setSource3_a_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_a_4());
    }

    @Test
    public void testRequested_a_4() throws Exception {
        fixture.setRequested_a_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_a_4());
    }

    @Test
    public void testSource1_b_4() throws Exception {
        fixture.setSource1_b_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_b_4());
    }

    @Test
    public void testSource2_b_4() throws Exception {
        fixture.setSource2_b_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_b_4());
    }

    @Test
    public void testSource3_b_4() throws Exception {
        fixture.setSource3_b_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_b_4());
    }

    @Test
    public void testRequested_b_4() throws Exception {
        fixture.setRequested_b_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_b_4());
    }

    @Test
    public void testSource1_c_4() throws Exception {
        fixture.setSource1_c_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1_c_4());
    }

    @Test
    public void testSource2_c_4() throws Exception {
        fixture.setSource2_c_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2_c_4());
    }

    @Test
    public void testSource3_c_4() throws Exception {
        fixture.setSource3_c_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3_c_4());
    }

    @Test
    public void testRequested_c_4() throws Exception {
        fixture.setRequested_c_4(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequested_c_4());
    }

    @Test
    public void testSource1Total() throws Exception {
        fixture.setSource1Total(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource1Total());
    }

    @Test
    public void testSource2Total() throws Exception {
        fixture.setSource2Total(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource2Total());
    }

    @Test
    public void testSource3Total() throws Exception {
        fixture.setSource3Total(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getSource3Total());
    }

    @Test
    public void testRequestedTotal() throws Exception {
        fixture.setRequestedTotal(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getRequestedTotal());
    }

    @Test
    public void testGrandTotal() throws Exception {
        fixture.setGrandTotal(amount);

        assertNotNull(fixture);
        assertEquals(amount, fixture.getGrandTotal());
    }
}