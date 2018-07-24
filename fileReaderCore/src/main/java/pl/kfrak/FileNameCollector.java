package pl.kfrak;

import java.io.*;
import java.util.Scanner;

/**
 * Created by kfrak on 10.06.2018.
 *
 *
 * ufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 //....
 int x,y;
 System.out.print("Enter Х: ");
 x = Integer.parseInt(reader.readLine());

 */
public class FileNameCollector {
    private BufferedReader bufferedReader;


    public FileNameCollector(InputStream inputStream) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String getFileNameFromUser() throws IOException {
        return bufferedReader.readLine();
    }
}
