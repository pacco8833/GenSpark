package genspark.projects.project4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Model {

    // game pieces
    private final Treasure cash = new Treasure();
    private final Goblin goblin = new Goblin();
    private final Human you;
    // number of rows and cols
    private final int squares;
    private String[][] map;

    Model(int numSquares) {
        this.squares = numSquares;
        you = new Human(squares);
        randomizePosition(goblin);
        randomizePosition(cash);
    }

    private void reMap(GamePiece character) {
        int x = character.getPosition().getX();
        int y = character.getPosition().getY();
        map[x][y] = character.toString();
    }

    private void defaultMap() {
        String TREE = "\uD83C\uDF33";
        map = new String[squares][squares];
        for (String[] x : map)
            Arrays.fill(x, TREE);
    }

    private ITEM dropper(GamePiece piece) {
        ITEM item = piece.drop();
        you.pickupItem(item);
        randomizePosition(piece);
        return item;
    }

    public String checkCollisions() {
        String message = null;
        //you got the treasure
        if (cash.getPosition().equals(you.getPosition()))
            message = "You received a " + dropper(cash) + " from the Treasure bag!";
        //the goblin caught you
        if (goblin.getPosition().equals(you.getPosition()))
            if (goblin.tryAttack(you)) {
                you.setHealth(you.getHealth() - 1);
                    message = """
                            This Monster just handed you your ass.
                            Game Over.
                            """;
                }
            else {
                message = "You killed that Monster and you picked up a " + dropper(goblin) + "!";
            }
        return message;
    }

    public void randomizePosition(GamePiece character) {
        final Random rand = new Random();
        int x = rand.nextInt(squares);
        int y = rand.nextInt(squares);
        character.setPosition(x, y);
    }

    public void reposition() {
        //update goblin's position
        goblin.chase(you);
        //all tress
        defaultMap();
        //update positions of...
        reMap(cash);
        reMap(goblin);
        reMap(you);
    }

    public HashMap<String, GamePiece> getGamePieces() {
        HashMap<String, GamePiece> pieces = new HashMap<>();
        pieces.put("player", you);
        pieces.put("monster", goblin);
        pieces.put("treasure", cash);
        return pieces;
    }

    public boolean moveUp() {
        return you.moveUp();
    }

    public boolean moveDown() {
        return you.moveDown();

    }

    public boolean moveLeft() {
        return you.moveLeft();
    }

    public boolean moveRight() {
        return you.moveRight();
    }

    public String[][] getMap() {
        return map;
    }
}
