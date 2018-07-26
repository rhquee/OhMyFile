package pl.kfrak;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AppTest {

    @Test(expected = IOException.class)
    public void shouldThrowsIOExceptionError() throws Exception {
        // TODO: 26.07.2018
    }

    @Test
    public void shouldReadandDisplayTextFromFile() throws IOException {
        //given
        String fileName = "test.txt";
        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
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
