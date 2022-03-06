package genspark.projects.project4;

import java.util.Random;

abstract class GamePiece {
    private Position position = new Position(0, 0);
    private final String[] drops = {"food", "water", "hammer", "potion"};

    public String drop() {
        Random rand = new Random();
        int dropNum = rand.nextInt(drops.length);
        return drops[dropNum];
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }
}