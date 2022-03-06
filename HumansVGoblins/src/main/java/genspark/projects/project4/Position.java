package genspark.projects.project4;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public Position setY(int row) {
        this.y = row;
        return this;
    }

    public int getX() {
        return x;
    }

    public Position setX(int col) {
        this.x = col;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x == position.getX() && y == position.getY();
    }
}
