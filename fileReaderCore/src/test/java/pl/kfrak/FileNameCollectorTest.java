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

//    Mockito.verify(mockedObject).someMethodOnMockedObject(Mockito.argThat(
//            Matchers.<SomeObjectAsArgument>hasProperty("propertyName", desiredValue)));

    @Test
    public void getFileNameFromUser() throws Exception {
        FileNameCollector fileNameCollector = mock(FileNameCollector.class);

        when(fileNameCollector.getFileNameFromUser()).thenReturn("text"); // FIXME: 23.07.2018
        assertEquals("text", fileNameCollector.getFileNameFromUser()); //expected, result
        //verify(fileNameCollector).getFileNameFromUser(argThat(Matchers.eq(fileNameCollector.getFileNameFromUser(), "text")));


    }
}