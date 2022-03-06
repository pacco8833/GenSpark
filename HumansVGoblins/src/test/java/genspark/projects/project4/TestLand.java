package genspark.projects.project4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestLand {

    Land land;
    Human guy = new Human();

    @Test
    public void noLand() {
        assertThrows(IllegalArgumentException.class, () -> land = new Land(3));
    }

    @Test
    public void onLand() {
        land = new Land(5);
        land.placeCharacter(guy);
        land.randomizePosition(guy);
        assertFalse(guy.getPosition().getX() == 0 && guy.getPosition().getY() == 0);
    }
}
