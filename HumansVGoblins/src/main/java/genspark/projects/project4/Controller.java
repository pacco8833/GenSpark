package genspark.projects.project4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {

    private final Model model;
    private final View view;

    Controller() {
        final int size = View.chooseDifficulty();
        model = new Model(size);
        view = new View(size);
        view.setSize(size * 150, size * 150);
        view.addKeyListener(new Listener());
        view.introduce(model.getGamePieces());
        redraw();
    }

    public static void main(String[] args) {
        new Controller();
    }

    private void redraw() {
        model.reposition();
        view.mapGamePieces(model.getMap());
        view.popupMsg(model.checkCollisions());
    }

    class Listener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            move(e.getKeyCode());
            redraw();
        }

        private void move(int direction) {
            switch (direction) {
                case 37: // up
                    if (!model.moveUp()) 
                        view.updateFrameMsg("You cannot go that way.");
                    break;
                case 38: // left
                    if (!model.moveLeft()) 
                        view.updateFrameMsg("You cannot go that way.");
                    break;
                case 39: // down
                    if (!model.moveDown()) 
                        view.updateFrameMsg("You cannot go that way.");
                    break;
                case 40: // right
                    if (!model.moveRight()) 
                        view.updateFrameMsg("You cannot go that way.");
                    break;
                case 32: 
                    view.updateFrameMsg("Exiting...");
                    System.exit(0);
                    break;
                default: {
                    view.updateFrameMsg("""
                            You can only go Up, Down ,Left, or Right"
                            "Input is done using the arrow keys."
                            "Press the spacebar to Quit."
                            "That Monster's still chasing you!
                            """);
                }
            }
        }
    }
}