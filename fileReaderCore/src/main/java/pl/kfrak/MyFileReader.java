package pl.kfrak;

import java.io.*;

public class MyFileReader {

    private String textFromFile;
    private String fileName;
    private BufferedReader reader;

    public MyFileReader(String fileName) {
        this.fileName = fileName;
        readMyFile();
//        System.out.println(removeSpaces());
    }

    public String removeSpaces() {
        return textFromFile != null ? textFromFile.replaceAll(" ", "") : "";
//        String result = "";
//        textFromFile.replaceAll(" ", "");
//        result = textFromFile;
//        return result;
    }

      private void readMyFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.fileName);

        if (inputStream == null) {
            System.out.println("Nie ma takiego pliku");
        } else {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            readAllLines();
        }
    }

    private void readAllLines() {
        try {
            String result = "";
            String line;

            while ((line = this.reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                result += line + "\n";
            }
            this.textFromFile = result;

        } catch (IOException e) {
            System.out.println("The specified file does not exist");
        }
    }

}