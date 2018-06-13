package pl.kfrak;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println("Podaj nazwę pliku, jaki chcesz otworzyć");
//        Scanner inputScanner = new Scanner(System.in);
//        String inputFromUser = inputScanner.nextLine();
        MyFileNameCollector myFileNameCollector = new MyFileNameCollector();
        String inputFromUser = myFileNameCollector.getFileNameFromUser();
        MyFileReader myFileReader = new MyFileReader(inputFromUser);
        System.out.println(myFileReader.removeSpaces());
    }
}
