package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

/**
 * Unit tests for EssayAnswer model.
 */
public class EssayAnswerTest {

    private EssayAnswer fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new EssayAnswer();
    }

    @Test
    public void testAnswerId() throws Exception {
        int id = 42;
        fixture.setAnswerId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getAnswerId());
    }

    @Test
    public void testAnswer() throws Exception {
        String answer = "Here is my very succinct answer: fund me!";
        fixture.setAnswer(answer);

        assertNotNull(fixture);
        assertTrue(answer.equals(fixture.getAnswer()));
    }

    @Test
    public void testQuestionId() throws Exception {
        int questionId = 2;
        fixture.setQuestionId(questionId);

        assertNotNull(questionId);
        assertEquals(questionId, fixture.getQuestionId());
    }

    @Test
    public void testGetProposalId() throws Exception {
        int proposalId = 32;
        fixture.setProposalId(proposalId);

        assertNotNull(fixture);
        assertEquals(proposalId, fixture.getProposalId());
    }

    @Test
    public void testGetUpdatedDate() throws Exception {
        LocalDate date = LocalDate.now();
        fixture.setUpdatedDate(date);

        assertNotNull(fixture);
        assertEquals(date, fixture.getUpdatedDate());
    }
}