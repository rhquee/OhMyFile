package pl.kfrak;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kfrak on 14.06.2018.
 */
public class TextTransformerTest {
    @Test
    public void shouldReturnTextWithoutSpacesFromBasicText() {
        //given
        String basic = "Lorem ipsum";
        String expected = "Loremipsum";

        //when
        String result = TextTransformer.removeSpaces(basic);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnNullFromNull() {
        //given
        String basic = null;
        String expected = null;

        //when
        String result = TextTransformer.removeSpaces(basic);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyResultFromSpaceOnly() {
        //given
        String basic = " ";
        String expected = "";

        //when
        String result = TextTransformer.removeSpaces(basic);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyResultFromSpaceAndEnter() {
        //given
        String basic = " /n";
        String expected = "/n";

        //when
        String result = TextTransformer.removeSpaces(basic);

        //then
        assertEquals(expected, result);
    }
}