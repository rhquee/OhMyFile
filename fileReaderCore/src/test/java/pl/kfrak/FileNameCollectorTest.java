package pl.kfrak;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FileNameCollectorTest {

    @Test
    public void shouldCheckIdentityOfEnteredText() throws Exception {
        //given
        String given = "test data";
        String expected = "test data";

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn(given);

        //when
        FileNameCollector fileNameCollector = new FileNameCollector(bufferedReader);
        String fileNameFromUser = fileNameCollector.getFileNameFromUser();

        //then
        verify(bufferedReader, times(1)).readLine();
        assertEquals(expected, fileNameFromUser);
    }
}