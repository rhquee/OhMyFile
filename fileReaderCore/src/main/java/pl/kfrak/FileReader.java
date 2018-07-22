package pl.kfrak;

import java.io.*;


public class FileReader {
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() throws IOException {
        InputStream inputStream = getFilepathAsStream();
        if (inputStream == null) {
            throw new FileNotFoundException("Nie znaleziono takiego pliku");
        } else {
            return readAllLines(new BufferedReader(new InputStreamReader(inputStream)));
        }
    }

    private InputStream getFilepathAsStream() {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    private String readAllLines(BufferedReader reader) throws IOException {
        String result = "";
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            result += line + "\n";
        }
        return result;
    }
}