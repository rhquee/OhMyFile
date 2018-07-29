package pl.kfrak;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AppTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowsNullPointerException() throws Exception {
        //given
        String fileName = "not.txt";
        FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);
        MessageDisplayer messageDisplayer = new MessageDisplayer();
        App app = new App();
        when(mockedFileNameCollector.getFileNameFromUser()).thenReturn(fileName);
        //when
        app.readAndTransformFileFromUsersInput(mockedFileNameCollector, messageDisplayer);
    }


    @Test
    public void shouldReadsAndDisplayTextFromFile() throws IOException {
        //given
        String fileName = "test.txt";
        FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);
        MessageDisplayer messageDisplayer = new MessageDisplayer();
        App app = new App();
        when(mockedFileNameCollector.getFileNameFromUser()).thenReturn(fileName);
        //when
        app.readAndTransformFileFromUsersInput(mockedFileNameCollector, messageDisplayer);
        //then
        Assert.assertEquals("Loremipsum", messageDisplayer.getMessage());
    }
}
