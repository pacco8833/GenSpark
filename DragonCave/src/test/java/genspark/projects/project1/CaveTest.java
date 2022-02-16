package genspark.projects.project1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CaveTest {
    // class to be tested
    DragonCave dCave = new DragonCave();

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 10 })
    public void chooseACave(Integer input) {
        String actual = dCave.caveDecision(input);
        assertNotNull(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 10 })
    public void chooseEnding(Integer input) {
        String actual = dCave.lifeDecision(input);
        assertNotNull(actual);
    }
}