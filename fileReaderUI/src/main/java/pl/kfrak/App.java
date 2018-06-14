package pl.kfrak;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println("Podaj nazwę pliku, jaki chcesz otworzyć");
//        Scanner inputScanner = new Scanner(System.in);
//        String inputFromUser = inputScanner.nextLine();
        try {
            MyFileNameCollector myFileNameCollector = new MyFileNameCollector();
            String inputFromUser = myFileNameCollector.getFileNameFromUser();
            MyFileReader myFileReader = new MyFileReader(inputFromUser);
            String file = myFileReader.readMyFile();
            String resultFileText = TextTransformer.removeSpaces(file);
            System.out.println(resultFileText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
