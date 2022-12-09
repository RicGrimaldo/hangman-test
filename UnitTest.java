import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class UnitTest {
    
    @Test
    public void cp_01() {
        assertTrue( new Game("e").checkIfLetter("e"));
    }

    @Test
    public void cp_06() {
        String[] letters = {"h","o","m","e","w","o","r","k"};
        assertFalse(new Game(null).checkLetter("t", letters));
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

}
