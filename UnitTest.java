import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class UnitTest {
    
    @Test
    public void cp_01() {
        assertTrue( new Game("e").checkIfLetter("e"));
    }

    @Test
    public void cp_03() {
        String letter = "f";
        ArrayList<String> letters = new ArrayList<>(Arrays.asList("a", "f", "p", "w"));

        assertTrue(new Game("test").checkIfEntered(letter, letters));
    }

    @Test
    public void cp_04() {
        String letter = "r";
        ArrayList<String> letters = new ArrayList<>(Arrays.asList("a", "f", "p", "w"));

        assertFalse(new Game("test").checkIfEntered(letter, letters));
    }

    @Test
    public void cp_06() {
        String[] letters = {"h","o","m","e","w","o","r","k"};
        assertFalse(new Game("t").checkLetter("t", letters));
    }

    @Test
    public void cp_08(){
        String[] letters = {"o","u","t","d","o","o","r"};
        String letter = "o";
        assertEquals(3, new Game("outdoors").checkTimesFound(letter, letters));
    }

    @Test
    public void cp_09() {
        String letter = "d";
        ArrayList<String> letters = new ArrayList<>(Arrays.asList("o", "t", "u"));
        ArrayList<String> expectedLetters = new ArrayList<>(Arrays.asList("o", "t", "u", "d"));

        new Game("test").addLetter(letter, letters);
        assertTrue(letters.equals(expectedLetters));
    }
    
    @Test
    public void cp_10(){
        LetterInput expectInput = new LetterInput();
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(new PlayAgain().wannaPlay());
    }

    @Test
    public void cp_11(){
        String input = "l";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(new PlayAgain().wannaPlay());
    }
    
    @Test
    public void cp_12() {
        LetterInput inputOutput= new LetterInput();

        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("a", inputOutput.input());
    }

    @Test
    public void cp_13() {
        LetterInput inputOutput= new LetterInput();

        String input = "et";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("e", inputOutput.input());
    }

    @Test
    public void cp_14() {
        String output = " a _ o _ a l _ _ s ";
        ArrayList<String> foundLetters;
        foundLetters = new ArrayList<String>();
        foundLetters.add("a");
        foundLetters.add("l");
        foundLetters.add("s");
        foundLetters.add("o");

        
        assertEquals(output, new Printer().printWord(foundLetters, "anomalies"));
    }

    @Test
    public void cp_15(){
        String esperado = "Is h present in word? --> Yes";
        assertEquals(esperado, new Printer().printIsLetterPresent("h", true));
    }

    @Test
    public void cp_16(){
        String output = "Is m present in word? --> No";
        assertEquals(output, new Printer().printIsLetterPresent("m", false));
    }

}
