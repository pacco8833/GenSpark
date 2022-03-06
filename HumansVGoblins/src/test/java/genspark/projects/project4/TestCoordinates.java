package genspark.projects.project4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCoordinates {

    Position p1 = new Position(1, 0);
    Position p2 = new Position(0, 0);

    @Test
    public void testTruePls() {
        p2.setPosition(1, 0);
        assertEquals(p1, p2);
    }
    
    @Test
    public void alsoTestTruePls() {
        p1 = new Position(0, 0);
        assertEquals(p1, p2);
    }

}
