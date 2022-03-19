package genspark.projects.project4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {
    private final Treasure cash = new Treasure();
    private final Goblin goblin = new Goblin();
    private final Model model;
    private final View view;
    private final Human you;
    private final int size;

    Controller() {
        size = View.chooseDifficulty();
        //initialize data
        model = new Model(size);
        model.randomizePosition(goblin);
        model.randomizePosition(cash);
        //get human
        you = model.getCharacter();
        //start frame
        view = new View("Monster Land", size);
        view.addKeyListener(new Listener());
        view.introduce(model.getGamePieces());
        redraw();
    }

    public static void main(String[] args) {
        new Controller();
    }

    private void redraw() {
        goblin.chase(you);
        model.defaultMap(size);
        model.reMap(cash);
        model.reMap(goblin);
        model.reMap(you);
        view.mapGamePieces(model.getMap());
        checkCollisions();
    }

    private void checkCollisions() {

        if (cash.getPosition().equals(you.getPosition())) {
            String item = cash.drop();
            model.randomizePosition(cash);
            you.pickupItem(item);
            view.popupMsg("You have received a " + item + " from the Treasure bag!");
        }
        if (goblin.getPosition().equals(you.getPosition())) {
            if (goblin.tryAttack(you)) {
                view.popupMsg("""
                        The Monster just handed you your ass.
                        Game Over.
                        """);
                System.exit(0);
            } else {
                String newItem = goblin.drop();
                you.pickupItem(newItem);
                view.popupMsg("You killed that Monster and you picked up a " + newItem + "!");
                model.randomizePosition(goblin);
            }
        }
    }

    class Listener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            move(e.getKeyCode());
        }

        private void move(int direction) {
            switch (direction) {
                case 37: // up
                    if (!model.moveUp()) {
                        view.updateFrameMsg("You cannot go that way.");
                    }
                    break;
                case 38: // left
                    if (!model.moveLeft()) {
                        view.updateFrameMsg("You cannot go that way.");
                    }
                    break;
                case 39: // down
                    if (!model.moveDown()) {
                        view.updateFrameMsg("You cannot go that way.");
                    }
                    break;
                case 40: // right
                    if (!model.moveRight()) {
                        view.updateFrameMsg("You cannot go that way.");
                    }
                    break;
                case 32: {
                    view.updateFrameMsg("Exiting...");
                    System.exit(0);
                    break;
                }
                default: {
                    view.updateFrameMsg("""
                            You can only go Up, Down ,Left, or Right"
                            "Input is done using the arrow keys."
                            "Press the spacebar to Quit."
                            "That Monster's still chasing you!
                            """);
                }
            }
            redraw();
        }
    }
}