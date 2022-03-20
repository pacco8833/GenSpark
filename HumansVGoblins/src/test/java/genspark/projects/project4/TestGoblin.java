package genspark.projects.project4;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TestGoblin {
    Human guy = new Human(3);
    Goblin goblin = new Goblin();

    @Test
    public void attackResults() {
        guy.setPosition(2, 1);
        assertFalse(goblin.tryAttack(guy));
    }

}
