package genspark.projects.project4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Model {

    private final Treasure cash = new Treasure();
    private final Goblin goblin = new Goblin();
    private final Human you = new Human();
    private final int squares;
    private String[][] map;

    Model(int numSquares) {
        this.squares = numSquares;
        defaultMap(squares);
    }

    public HashMap<String, String> getGamePieces() {
        HashMap<String, String> pieces = new HashMap<>();
        pieces.put("player", you.toString());
        pieces.put("monster", goblin.toString());
        pieces.put("treasure", cash.toString());
        return pieces;
    }


    public void reMap(GamePiece character) {
        int x = character.getPosition().getX();
        int y = character.getPosition().getY();
        map[x][y] = character.toString();
    }

    public void randomizePosition(GamePiece character) {
        final Random rand = new Random();
        int x = rand.nextInt(squares);
        int y = rand.nextInt(squares);
        character.setPosition(x, y);
    }

    public void defaultMap(int square) {
        String TREE = "\uD83C\uDF33";
        map = new String[square][square];
        for (String[] x : map)
            Arrays.fill(x, TREE);
    }

    public boolean moveUp() {
        if (you.getPosition().getY() > 0) {
            you.getPosition().setY(you.getPosition().getY() - 1);
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (you.getPosition().getX() > 0) {
            you.getPosition().setX(you.getPosition().getX() - 1);
            return true;
        }
        return false;
    }

    public boolean moveDown() { // down
        if (you.getPosition().getY() < squares - 1) {
            you.getPosition().setY(you.getPosition().getY() + 1);
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (you.getPosition().getX() < squares - 1) {
            you.getPosition().setX(you.getPosition().getX() + 1);
            return true;
        }
        return false;
    }

    public String[][] getMap() {
        return map;
    }

    public Human getCharacter(){
        return you;
    }
}
