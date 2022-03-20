package genspark.projects.project4;

import java.util.ArrayList;

public class Human extends GamePiece {

    private final ArrayList<ITEM> inventory = new ArrayList<>();
    private final int size;
    private boolean isAlive = false;
    private int strength = 1;
    private int maxHealth = 5;
    private int health = 5;


    Human(int squares) {
        this.size = squares;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health == 0)
            died();
    }

    public void died() {
        isAlive = false;
    }

    public void pickupItem(ITEM item) {
        inventory.add(item);
        switch (item) {
            case WATER -> health = maxHealth;
            case HAMMER -> {
                if (maxHealth <= 10)
                    maxHealth++;
            }
            case FOOD -> {
                if (health <= maxHealth)
                    health++;
            }
            case POTION -> {
                if (strength <= 5)
                    strength++;
            }
        }
    }

    public ArrayList<ITEM> getItems() {
        return inventory;
    }

    public boolean moveUp() {
        if (this.getPosition().getY() > 0) {
            this.getPosition().setY(this.getPosition().getY() - 1);
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (this.getPosition().getX() > 0) {
            this.getPosition().setX(this.getPosition().getX() - 1);
            return true;
        }
        return false;
    }

    public boolean moveDown() { // down
        if (this.getPosition().getY() < size - 1) {
            this.getPosition().setY(this.getPosition().getY() + 1);
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (this.getPosition().getX() < size - 1) {
            this.getPosition().setX(this.getPosition().getX() + 1);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\uD83D\uDD7A";
    }
}
