package eRSPG.model.form;

import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * Unit tests for UploadForm model.
 */
public class UploadFormTest {

    private UploadForm fixture;

    @BeforeMethod
    public void setUp() throws Exception {
        fixture = new UploadForm();
    }

    @Test
    public void testName() throws Exception {
        String name = "UploadFile.txt";
        fixture.setName(name);

        assertNotNull(fixture);
        assertTrue(name.equals(fixture.getName()));
    }

    @Test
    public void testFileUpload() throws Exception {
        MultipartFile file = mock(MultipartFile.class);
        byte[] contents = {0,1,1,0,0,1,1,0};
        String contentType = "Text";
        String name = "UploadFile.txt";
        String originalName = "WhatsUp.txt";
        long size = 1;

        InputStream stream = mock(InputStream.class);

        when(stream.markSupported()).thenReturn(true);

        when(file.getBytes()).thenReturn(contents);
        when(file.getContentType()).thenReturn(contentType);
        when(file.getInputStream()).thenReturn(stream);
        when(file.getName()).thenReturn(name);
        when(file.getOriginalFilename()).thenReturn(originalName);
        when(file.getSize()).thenReturn(size);
        when(file.isEmpty()).thenReturn(false);

        fixture.setFileUpload(file);

        assertNotNull(fixture);
        assertEquals(contents, fixture.getFileUpload().getBytes());
        assertTrue(contentType.equals(fixture.getFileUpload().getContentType()));
        assertTrue(name.equals(fixture.getFileUpload().getName()));
        assertTrue(originalName.equals(fixture.getFileUpload().getOriginalFilename()));
        assertEquals(size, fixture.getFileUpload().getSize());
        assertEquals(stream, fixture.getFileUpload().getInputStream());
    }
}