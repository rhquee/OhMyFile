package pl.kfrak;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;


public class MessageDisplayerTest {
    @Test
    public void shouldDisplayTextFromSetOutOutputStream() throws Exception {
        //given
        MessageDisplayer messageDisplayer = new MessageDisplayer();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //Reassigns the "standard" output stream.
        System.setOut(new PrintStream(byteArrayOutputStream));
        //when
        messageDisplayer.setMessage("abc");
        messageDisplayer.displayText();
        String message = new String(byteArrayOutputStream.toByteArray());
        //then
        Assert.assertEquals(message, "abc\r\n"); //MessageDisplayer używa System.out.println(), a tam na końcu generuje sie breakline (doc)
    }

    @Test
    public void checkIfMethodIsDoneOnce() throws Exception {
        MessageDisplayer mockedMessageDisplayer = mock(MessageDisplayer.class);
        mockedMessageDisplayer.displayText();
        verify(mockedMessageDisplayer, times(1)).displayText();
    }
}