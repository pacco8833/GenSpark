package genspark.projects.project4;

import java.util.Scanner;

public class GoblinLand {

    private final Scanner me = new Scanner(System.in);
    private final Treasure cash = new Treasure();
    private final Goblin goblin = new Goblin();
    private final Human you = new Human();
    private final Land forest;
    private final int size = 5;

    GoblinLand() {
        forest = new Land(size);
        forest.randomizePosition(goblin);
        forest.randomizePosition(cash);
        introduce();
        mainGameLoop();
    }

    public static void main(String[] args) {
        new GoblinLand();
    }

    private void introduce() {
        String intro = ("""
                Look fool, this is You --> %you
                You can only move N,S,E,W.
                        
                You are in MonsterLand,
                Grab some treasure while you're here --> %cash
                    
                Run from the enemy while you can!
                He WILL pursue you. --> %goblin
                You will die if he catches you!
                        
                """);
        intro = intro.replace("%you", you.toString());
        intro = intro.replace("%goblin", goblin.toString());
        intro = intro.replace("%cash", cash.toString());
        System.out.println(intro);
    }

    private void mainGameLoop() {
        String direction;
        do {
            if (checkCollisions()) break;
            redraw();
            System.out.println("""
                                        
                    What direction will you go in...?
                    Your response:""");
            direction = usersDirection();
            move(direction);
            goblin.chase(you);
        } while (!direction.equals("exit"));
        endGame();
    }

    private void redraw() {
        forest.defaultMap(size);
        forest.placeCharacter(you);
        forest.placeCharacter(goblin);
        forest.placeCharacter(cash);
        forest.printMap();
    }

    private boolean checkCollisions() {

        if (cash.getPosition().equals(you.getPosition())) {
            String item = cash.drop();
            forest.randomizePosition(cash);
            you.pickupItem(item);
            System.out.println("You have received a " + item + " from the Treasure bag!");
        }

        if (goblin.getPosition().equals(you.getPosition())) {
            if (goblin.tryAttack(you)) {
                System.out.println("The Goblin just handed you your ass.");
                return true;
            } else {
                String newItem = goblin.drop();
                you.pickupItem(newItem);
                System.out.println("You killed that monster and you picked up a " + newItem + "!");
                forest.randomizePosition(goblin);
            }
        }
        return false;
    }

    private void move(String direction) {
         direction = direction.toUpperCase().trim().charAt(0) + "";
        switch (direction) {
            case "N":
                if (you.getPosition().getX() > 0) {
                    you.getPosition().setX(you.getPosition().getX() - 1);
                } else {
                    System.out.println("You cannot go that way.");
                }
                break;
            case "W":
                if (you.getPosition().getY() > 0) {
                    you.getPosition().setY(you.getPosition().getY() - 1);
                } else {
                    System.out.println("You cannot go that way.");
                }
                break;
            case "E":
                if (you.getPosition().getY() < size - 1) {
                    you.getPosition().setY(you.getPosition().getY() + 1);
                } else {
                    System.out.println("You cannot go that way.");
                }
                break;
            case "S":
                if (you.getPosition().getX() < size - 1) {
                    you.getPosition().setX(you.getPosition().getX() + 1);
                } else {
                    System.out.println("You cannot go that way.");
                }
                break;
            case "EXIT": {
                System.out.println("Exiting...");
                break;
            }
            default: {
                System.out.println("You can only go N,S,E, or W.");
                System.out.println("That Monster's still chasing you!");
            }
        }
    }

    private String usersDirection() {
        String fullLine;
        try {
            fullLine = me.nextLine().toUpperCase().trim().charAt(0) + "";
            return fullLine;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Enter something ya schmuck!");
        }
        return usersDirection();
    }

    private void endGame() {
        me.close();
        System.out.println("Game Over.");
        System.exit(0);
    }
}