package eRSPG.model;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit tests for UploadFile model.
 */
public class UploadFileTest {

    private UploadFile fixture; 
    
    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new UploadFile();
    }

    @Test
    public void testId() throws Exception {
        int id = 64;
        fixture.setId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getId());
    }

    @Test
    public void testProposalId() throws Exception {
        int id = 128;
        fixture.setProposalId(id);

        assertNotNull(fixture);
        assertEquals(id, fixture.getProposalId());
    }

    @Test
    public void testFileName() throws Exception {
        String fileName = "y ert+";
        fixture.setFileName(fileName);

        assertNotNull(fixture);
        assertTrue(fileName.equals(fixture.getFileName()));
    }

    @Test
    public void testPath() throws Exception {
        String path = "C:\\Windows\\System32";
        fixture.setPath(path);

        assertNotNull(path);
        assertTrue(path.equals(fixture.getPath()));
    }
}