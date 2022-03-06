package genspark.projects.project1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TextTest {

    static String actual;

    @Test
    public void deaths() {
        actual = DragonText.getDeath();
        assertNotNull(actual, "If the user doesn't get a msg, they wouldn't know they died.");
    }

    @Test
    public void intros() {
        actual = DragonText.getIntro();
        assertNotNull(actual, "If the user doesn't get an intro msg, they wouldn't know where they arr.");
    }
}
