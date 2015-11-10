package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for EssayQuestion DTO.
 */
public class EssayQuestionTest {

    private EssayQuestion fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new EssayQuestion();
    }

    @Test
    public void testQuestionId() throws Exception {
        int id = 64;
        fixture.setQuestionId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getQuestionId());
    }

    @Test
    public void testGetQuestion() throws Exception {
        String question = "What is the airspeed velocity of an unlaiden swallow?";
        fixture.setQuestion(question);

        assertNotNull(fixture);
        assertTrue(question.equals(fixture.getQuestion()));
    }
}