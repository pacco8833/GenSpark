package genspark.projects.project4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestModel {

    Model model;
    Human guy = new Human();

    @Test
    public void noLand() {
        assertThrows(IllegalArgumentException.class, () -> model = new Model(3));
    }

    @Test
    public void onLand() {
        model = new Model(5);
        model.reMap(guy);
        model.randomizePosition(guy);
        assertFalse(guy.getPosition().getX() == 0 && guy.getPosition().getY() == 0);
    }
}
