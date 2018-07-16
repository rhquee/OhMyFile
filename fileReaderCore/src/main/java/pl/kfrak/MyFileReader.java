package pl.kfrak;

import java.io.*;


public class MyFileReader {

    private String fileName;
    private BufferedReader reader;


    public MyFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readMyFile() throws IOException {
        InputStream inputStream = getPath();

        if (inputStream == null) {
            throw new FileNotFoundException("File not found!");
        } else {
            this.reader = new BufferedReader(new InputStreamReader(inputStream));
            return readAllLines();
        }
    }

    private InputStream getPath() {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    private String readAllLines() throws IOException {
        String result = "";
        String line;

        while ((line = this.reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            result += line + "\n";
        }
        return result;
    }
}