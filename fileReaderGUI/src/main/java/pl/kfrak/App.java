package pl.kfrak;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new App().readAndTransformFileFromUsersInput(new FileNameCollector(System.in), new MessageDisplayer());
    }

    //BufferedReader
    public void readAndTransformFileFromUsersInput(FileNameCollector input, MessageDisplayer output) {
        try {
//            input = new FileNameCollector(System.in);
            MessageDisplayer.displayText("Wskaż plik poprzez wpisanie jego nazwy oraz zatwierdzenie enterem.\nNastępnie program bezspacjowo odczyta zawartość pliku.");
            String inputFromUser = input.getFileNameFromUser();
            FileReader fileReader = new FileReader(inputFromUser);
            String file = fileReader.readFile();
            String resultFileText = TextTransformer.removeSpaces(file);
//            output = new MessageDisplayer();
            output.displayText(resultFileText);
        } catch (IOException e) {
            MessageDisplayer.displayText(e.getMessage());
        }
    }
}
