package pl.kfrak;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.*;

/**
 * Created by kfrak on 14.06.2018.
 */
public class MyFileReaderTest {

    @Test
    public void readMyFile_simpleCase() throws IOException {
        //given
        String testFileName = "simpleCaseFile.txt";
        String expected = "A B C\n" +
                "D e f g\n";

        //when
        MyFileReader myFileReader = new MyFileReader(testFileName);
        String result = myFileReader.readMyFile();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void readMyFile_emptyFile() throws Exception {
        //given
        String testFileName = "emptyFile.txt";
        String expected = "";

        //when
        MyFileReader myFileReader = new MyFileReader(testFileName);
        String result = myFileReader.readMyFile();

        //then
        assertEquals(expected, result);
    }

    @Test
    public void readMyFile_enter() throws Exception {
        //given
        String testFileName = "onlyEnterFile.txt";
        String expected = "";

        //when
        MyFileReader myFileReader = new MyFileReader(testFileName);
        String result = myFileReader.readMyFile();

        //then
        assertEquals(expected, result);
    }

//    @Test (expected = NoSuchFileException.class)
//    public void readMyFile_notExistingFile() throws Exception {
//        //given
//        String testFileName = "not.txt";
//
//        //when
//        MyFileReader myFileReader = new MyFileReader(testFileName);
//
//        //then
//    }

}