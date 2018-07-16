package pl.kfrak;

/**
 * Created by kfrak on 14.06.2018.
 */
public class TextTransformer {

    public static String removeSpaces(String text) {
        return text != null ? text.replaceAll(" ", "") : "";
    }
}
