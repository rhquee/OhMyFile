package pl.kfrak;

import org.junit.Test;
import org.mockito.Matchers;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kfrak on 23.07.2018.
 */
public class FileNameCollectorTest {

    @Test
    public void getFileNameFromUser() throws Exception {
        FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);

        when(mockedFileNameCollector.getFileNameFromUser()).thenReturn("text"); // FIXME: 23.07.2018
        assertEquals("text", mockedFileNameCollector.getFileNameFromUser()); //expected, result
        //verify(mockedFileNameCollector).getFileNameFromUser(argThat(Matchers.eq(mockedFileNameCollector.getFileNameFromUser(), "text")));


    }
}