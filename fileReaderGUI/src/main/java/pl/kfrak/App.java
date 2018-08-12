package pl.kfrak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        new App().run(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out, true)); //true, zeby zaflushowało
    }

    public void run(BufferedReader in, PrintWriter out) {
        out.println("Wskaż plik poprzez wpisanie jego nazwy oraz zatwierdzenie enterem.\nNastępnie program bezspacjowo odczyta zawartość pliku.");
        this.readAndTransformFileFromUsersInput(new FileNameCollector(in), out);
    }


    public void readAndTransformFileFromUsersInput(FileNameCollector input, PrintWriter out) {
        try {
            String inputFromUser = input.getFileNameFromUser();
            FileReader fileReader = new FileReader(inputFromUser);
            String file = fileReader.readFile();
            String resultFileText = TextTransformer.removeSpaces(file);
            out.println(resultFileText);
        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }
}
