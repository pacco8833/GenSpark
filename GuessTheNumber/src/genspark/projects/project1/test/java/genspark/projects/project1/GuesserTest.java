package genspark.projects.project1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GuesserTest {

    NumberGuesser ng = new NumberGuesser("Carl");

    void getNames() {
        String name = ng.player.getName();
        assertEquals("Carl", name);
    }

    void randomizeNumber() {
        int maximumNum = 60;
        ng = new NumberGuesser("Carl", maximumNum);
        assertAll("Make sure max num registers",
                () -> assertEquals(maximumNum, ng.maxNumber),
                () -> assertNotEquals(20, ng.maxNumber));
    }

}
