package genspark.projects.project1;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        int num = 99;
        NumberGuesser guesser = new NumberGuesser("Carl", num);
        assertNotEquals(20, guesser.maxNumber, "Should not equal 20 when we set num in the constructor.");
    }
}
