package pl.kfrak;

import java.io.*;

public class FileNameCollector {
    private BufferedReader bufferedReader;


    public FileNameCollector(InputStream inputStream) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String getFileNameFromUser() throws IOException {
        return bufferedReader.readLine();
    }
}
