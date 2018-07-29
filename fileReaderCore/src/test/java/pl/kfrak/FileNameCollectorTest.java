package pl.kfrak;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileNameCollectorTest {

    @Test
    public void shouldCheckIdentityOfEnteredText() throws Exception {
        //given
        String given = "test data";
        String expected = "test data";
        InputStream inputStream = new ByteArrayInputStream(given.getBytes());
        FileNameCollector fileNameCollector = new FileNameCollector(inputStream);
        //when
        fileNameCollector.getFileNameFromUser();
        //then
        assertEquals(expected, given);
    }
}