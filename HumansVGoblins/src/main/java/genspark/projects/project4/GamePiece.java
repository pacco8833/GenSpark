package genspark.projects.project4;

abstract class GamePiece {
    private Position position = new Position(0, 0);

    public ITEM drop() {
        return ITEM.getRandomItem();
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }

}

