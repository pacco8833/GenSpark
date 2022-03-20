package genspark.projects.project4;

import java.util.Random;

public enum ITEM {

    FOOD, WATER, HAMMER, POTION;

    public static ITEM getRandomItem(){
        Random rand = new Random();
        ITEM[] items = ITEM.values();
        int dropNum = rand.nextInt(items.length);
        return items[dropNum];
    }

    public static String nameOf(ITEM i) {
        return i.toString();
    }
}

