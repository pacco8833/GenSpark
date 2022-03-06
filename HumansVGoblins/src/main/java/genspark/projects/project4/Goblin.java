package genspark.projects.project4;

import java.util.Random;

public class Goblin extends GamePiece {

    public boolean tryAttack(Human guy) {
        Random rand = new Random();
        if (guy.getPosition().equals(this.getPosition()))
            return rand.nextInt(2) == 0;
        return false;
    }

    public void chase(Human guy) {
        int humanHeight = guy.getPosition().getY();
        int humanWidth = guy.getPosition().getX();
        int goblinHeight = this.getPosition().getY();
        int goblinWidth = this.getPosition().getX();

        if (goblinWidth == humanWidth) {
            if (humanHeight > goblinHeight) {
                this.setPosition(goblinWidth, ++goblinHeight);
            } else {
                this.setPosition(goblinWidth, --goblinHeight);
            }
        } else if (goblinHeight == humanHeight) {
            if (humanWidth < goblinWidth) {
                this.setPosition(--goblinWidth, goblinHeight);
            } else {
                this.setPosition(++goblinWidth, goblinHeight);
            }
        } else {
            Random rand = new Random();
            int randomDecision = rand.nextInt(2);

            if (randomDecision == 0) {
                if (humanWidth < goblinWidth) {
                    this.setPosition(--goblinWidth, goblinHeight);
                } else {
                    this.setPosition(++goblinWidth, goblinHeight);
                }
            } else {
                if (humanHeight > goblinHeight) {
                    this.setPosition(goblinWidth, ++goblinHeight);
                } else {
                    this.setPosition(goblinWidth, --goblinHeight);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "\uD83D\uDC32";
    }
}
