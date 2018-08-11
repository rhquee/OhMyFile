package pl.kfrak;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;

public class AppTest {

    @Test
    public void shouldShowNotFoundFileMessage() throws Exception {
        //given
        String fileName = "not.txt";
        FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);
        PrintWriter output = mock(PrintWriter.class);

        when(mockedFileNameCollector.getFileNameFromUser()).thenReturn(fileName);

        // when
        new App().readAndTransformFileFromUsersInput(mockedFileNameCollector, output);

        // then
        verify(output).println("Nie znaleziono takiego pliku");
    }


    @Test
    public void shouldReadsAndDisplayTextFromFile() throws IOException {
        //given
        String fileName = "test.txt";
        FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);
        PrintWriter out = mock(PrintWriter.class);
        when(mockedFileNameCollector.getFileNameFromUser()).thenReturn(fileName);

        //when
        App app = new App();
        app.readAndTransformFileFromUsersInput(mockedFileNameCollector, out);

        //then
        verify(out).println("Loremipsum");
    }
}
