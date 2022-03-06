package genspark.projects.project4;

import java.util.Arrays;
import java.util.Random;

public class Land {

    private final int squares;
    private String[][] map;

    Land(int numSquares) {
        if (numSquares <= 3) throw new IllegalArgumentException("There must be at lease enough space for 3 Game pieces");
        this.squares = numSquares;
        defaultMap(squares);
    }

    public void placeCharacter(GamePiece character) {
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

    public void printMap() {
        for (String[] rows : map) {
            for (String cols : rows)
                System.out.print(cols);
            System.out.println();
        }
    }
}
