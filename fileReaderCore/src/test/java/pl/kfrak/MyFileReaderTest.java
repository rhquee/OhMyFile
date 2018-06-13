package pl.kfrak;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by kfrak on 13.06.2018.
 */
public class MyFileReaderTest extends TestCase {

    //The TemporaryFolder Rule allows creation of files and folders that
    // should be deleted when the test method finishes (whether it passes or fails).
    //https://stackoverflow.com/questions/43193188/junit-before-vs-rule

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();



    @Test
    public void readMyFile_simpleCaseFile() throws Exception {
        //given
        String testFileName = ".src/test/resources/simpleCaseFile.txt";
        File file = tempFolder.newFile(testFileName);
        String expected = "A B C\n" +
                "D e f g";

        //when
        MyFileReader myFileReader = new MyFileReader();
        String result = MyFileReader.readMyFile(testFileName);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void readMyFile_emptyFile() throws Exception {
        File testFile = tempFolder.newFile(".src/test/resources/emptyFile.txt");
    }

    @Test
    public void readMyFile_onlySpaces() throws Exception {
        File testFile = tempFolder.newFile(".src/test/resources/onlySpacesFile.txt");
    }

    @Test
    public void readMyFile_enter() throws Exception {
        File testFile = tempFolder.newFile(".src/test/resources/onlyEnterFile.txt");

    }

    @Test (expected = NullPointerException.class)
    public void readMyFile_notExistingFile() throws Exception {

    }

}