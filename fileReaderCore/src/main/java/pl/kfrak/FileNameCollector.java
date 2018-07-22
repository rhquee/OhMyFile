package pl.kfrak;

import java.util.Scanner;

/**
 * Created by kfrak on 10.06.2018.
 */
public class FileNameCollector {
    private Scanner inputScanner;

    public FileNameCollector() {
        this.inputScanner = new Scanner(System.in);
    }

    public String getFileNameFromUser() {
        System.out.println("Wskaż plik poprzez wpisanie jego nazwy oraz zatwierdzenie enterem.\nNastępnie program bezspacjowo odczyta zawartość pliku.");
        return inputScanner.nextLine();
    }
}
