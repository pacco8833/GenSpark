package genspark.projects.project3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class HangmanTest {
    static Hangman h = new Hangman();

    @Test
    public void changeHashCharacter() {
        char expected = 'q';
        h.setHashCharacter(expected + "");
        assertEquals(expected, h.getHashCharacter(), "Makes sure we can change our hashCharacter");
    }

    @AfterAll
    public static void endItAll(){
        h.finishHim();
    }
}