package genspark.projects.project2;

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
        NumberGuesser guesser = new NumberGuesser();
        assertNotEquals(20, guesser.maxNumber, "Should not equal 20 when we set num in the constructor.");
    }
}
