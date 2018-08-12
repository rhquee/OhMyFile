package pl.kfrak;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;
import static pl.kfrak.TextTransformer.removeSpaces;

/**
 * 1) wyjątek z catcha - porównanie outputu z treścią wyjątku,
 * 2) wynik poprawny - porównanie outputu z odspacjowaną treścią z pliku.
 * 3) sprawdzenie czy wywoływane są odpowiednie metody przez metodę run()
 * 4) sprawdzenie czy wywoływane są odpowiednie metody przez metodę readAndTransformFileFromUsersInput()
 * **/


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
            //FileNameCollector mockedFileNameCollector = mock(FileNameCollector.class);
            //when(mockedFileNameCollector.getFileNameFromUser()).thenReturn(fileName);
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

        TextTransformer textTransformer = spy(TextTransformer.class);

        // then
        verify(mockedFileNameCollector, times(1)).getFileNameFromUser();
        verify(TextTransformer, times(1)).removeSpaces(anyString());
        verify(mockedPrintWriter, times(1)).println("Loremipsum");
    }
}