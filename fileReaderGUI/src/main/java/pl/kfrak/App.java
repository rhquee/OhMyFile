package pl.kfrak;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new App().readAndTransformFileFromUsersInput(System.in, System.out);
    }




    // BufferedReader
    public void readAndTransformFileFromUsersInput(InputStream in, PrintStream out) {
        try {
            FileNameCollector fileNameCollector = new FileNameCollector();
            String inputFromUser = fileNameCollector.getFileNameFromUser();
            FileReader fileReader = new FileReader(inputFromUser);
            String file = fileReader.readFile();
            String resultFileText = TextTransformer.removeSpaces(file);
            System.out.println(resultFileText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
