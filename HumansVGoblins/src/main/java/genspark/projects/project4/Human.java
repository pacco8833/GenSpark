package genspark.projects.project4;

import java.util.ArrayList;

public class Human extends GamePiece {

    private final ArrayList<String> inventory = new ArrayList<>();

    public void pickupItem(String item) {
        inventory.add(item);
    }

    public ArrayList<String> getItems() {
        return inventory;
    }

    @Override
    public String toString() {
        return "\uD83D\uDD7A";
    }
}
