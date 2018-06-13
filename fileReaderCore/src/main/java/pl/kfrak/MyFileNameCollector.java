package pl.kfrak;

import java.util.Scanner;

/**
 * Created by kfrak on 10.06.2018.
 */
public class MyFileNameCollector {

    private Scanner inputScanner;

    public MyFileNameCollector() {
        this.inputScanner = new Scanner(System.in);
    }

    public String getFileNameFromUser() {
        System.out.println("Podaj nazwę pliku, jaki chcesz otworzyć");
        return this.inputScanner.nextLine();
    }
}
