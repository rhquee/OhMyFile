package pl.kfrak;

import java.io.*;

public class FileNameCollector {
    private BufferedReader bufferedReader;


    public FileNameCollector(BufferedReader inputStream) {
        this.bufferedReader = inputStream;
    }

    public String getFileNameFromUser() throws IOException {
        return bufferedReader.readLine();
    }
}
