package pl.kfrak;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kfrak on 14.06.2018.
 */
public class FileReaderTest {

    @Test
    public void shouldReturnContentWithoutSpacesFromExistingFile() throws IOException {
        //given
        String testFileName = "simpleCaseFile.txt";
        String expected = "A B C\n" +
                "D e f g\n";

        //when
        FileReader fileReader = new FileReader(testFileName);
        String result = fileReader.readFile();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyResultForEmptyFile() throws Exception {
        //given
        String testFileName = "emptyFile.txt";
        String expected = "";

        //when
        FileReader fileReader = new FileReader(testFileName);
        String result = fileReader.readFile();

        //then
        assertEquals(expected, result);
    }


    @Test (expected = FileNotFoundException.class)
    public void shouldThrowFileNotFoundExceptionWhenFileDoesntExist() throws Exception {
        //given
        String testFileName = "not.txt";

        //when
        FileReader fileReader = new FileReader(testFileName);

        //then
        fileReader.readFile();
    }

}