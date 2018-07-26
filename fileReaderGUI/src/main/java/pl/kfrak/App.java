package pl.kfrak;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        MessageDisplayer messageDisplayer = new MessageDisplayer();
        messageDisplayer.setMessage("Wskaż plik poprzez wpisanie jego nazwy oraz zatwierdzenie enterem.\nNastępnie program bezspacjowo odczyta zawartość pliku.");
        messageDisplayer.displayText();
        new App().readAndTransformFileFromUsersInput(new FileNameCollector(System.in), new MessageDisplayer());
    }

    public void readAndTransformFileFromUsersInput(FileNameCollector input, MessageDisplayer output) {
        try {

            String inputFromUser = input.getFileNameFromUser();
            FileReader fileReader = new FileReader(inputFromUser);
            String file = fileReader.readFile();
            String resultFileText = TextTransformer.removeSpaces(file);
            //output.displayText(resultFileText);
            output.setMessage(resultFileText);
            output.displayText();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
