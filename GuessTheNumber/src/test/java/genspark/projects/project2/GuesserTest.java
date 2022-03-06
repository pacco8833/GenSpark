package genspark.projects.project2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GuesserTest {

    NumberGuesser ng = new NumberGuesser();

    void getNames() {
        String name = ng.player.getName();
        assertEquals("Carl", name);
    }

    void randomizeNumber() {
        int maximumNum = 60;
        ng = new NumberGuesser();
        assertAll("Make sure max num registers",
                () -> assertEquals(maximumNum, ng.maxNumber),
                () -> assertNotEquals(20, ng.maxNumber));
    }

}
