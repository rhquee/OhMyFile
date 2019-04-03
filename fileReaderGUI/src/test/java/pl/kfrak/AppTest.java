package pl.kfrak;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void shouldShowNotFoundFileMessage() throws Exception {
        //given
        String fileName = "not.txt";
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        PrintWriter mockedPrintWriter = mock(PrintWriter.class);

        when(mockedBufferedReader.readLine()).thenReturn(fileName);

        // when
        new App().run(mockedBufferedReader, mockedPrintWriter);

        // then
        verify(mockedPrintWriter).println("Nie znaleziono takiego pliku");
    }

    @Test
    public void shouldCheckIfInputAndOutputAreTheSame() throws Exception {
        //given
        String fileName = "test.txt";
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        PrintWriter mockedPrintWriter = mock(PrintWriter.class);

        when(mockedBufferedReader.readLine()).thenReturn(fileName);

        // when
        new App().run(mockedBufferedReader, mockedPrintWriter);

        // then
        verify(mockedPrintWriter).println("Loremipsum");
    }

    @Test
    public void shouldCheckIfExpectedMethodsAreCalled() throws Exception {
        //given
        String fileName = "test.txt";
        PrintWriter mockedPrintWriter = mock(PrintWriter.class);
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);

        when(mockedBufferedReader.readLine()).thenReturn(fileName);

        // when
        App spyApp = spy(App.class);
        spyApp.run(mockedBufferedReader, mockedPrintWriter);

        // then
        verify(spyApp, times(1)).readAndTransformFileFromUsersInput(any(FileNameCollector.class), eq(mockedPrintWriter));
        verify(mockedPrintWriter, times(1)).println("Wskaż plik poprzez wpisanie jego nazwy oraz zatwierdzenie enterem.\nNastępnie program bezspacjowo odczyta zawartość pliku.");
    }

    @Test
    public void shouldCheckIfExpectedMethodsAreCalled2() throws Exception {
        //given
        String fileName = "test.txt";
        PrintWriter mockedPrintWriter = mock(PrintWriter.class);

        FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);
        when(mockedFileNameCollector.getFileNameFromUser()).thenReturn(fileName);

        // when
        App spyApp = spy(App.class);
        spyApp.readAndTransformFileFromUsersInput(mockedFileNameCollector, mockedPrintWriter);

        // then
        verify(mockedFileNameCollector, times(1)).getFileNameFromUser();
        verify(mockedPrintWriter, times(1)).println("Loremipsum");
    }
}