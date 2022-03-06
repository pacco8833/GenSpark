package genspark.projects.project4;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestComponent {

    GamePiece cash = new Treasure();

    @Test
    public void noOverflow() {
        int x = 5, y = 5;
        cash.setPosition(x, y);
        
        assertAll("Position",
        ()->assertEquals(x,cash.getPosition().getX()),
        ()->assertEquals(y,cash.getPosition().getY()));
    }

}
