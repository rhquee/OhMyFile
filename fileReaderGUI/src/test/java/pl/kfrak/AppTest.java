package pl.kfrak;


import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Matchers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 Chuj chuj = Mock (Chuj.class):
 when(chuj.ruchaj ()).thenReturn (new Sperma);


 when(chuj.ruchaj (any (Cipka.class)).thenReturn (new Sperma);

 */
public class AppTest {

    @Test
    public void readAndTransformFileFromUsersInput() throws IOException {

        FileReader mockedFileReader = mock(FileReader.class);
        when(mockedFileReader.readFile(any(BufferedInputStream.class))).thenReturn("aaa");

//        verify(mockedFileNameCollector).getFileNameFromUser(argThat(Matchers.eq(mockedFileNameCollector.getFileNameFromUser(), "text")));

        verify(mockedFileReader).readFile(argThat()
    }
}
