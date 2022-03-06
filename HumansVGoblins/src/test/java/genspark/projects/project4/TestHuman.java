package genspark.projects.project4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestHuman {

    Human guy = new Human();
    
    @Test
    public void createInventoryItem() {
        String item = "1 straw penny";
        ArrayList<String> array;
        guy.pickupItem(item);
        array = guy.getItems();
        assertEquals(item, array.get(array.size() -1));
    }

}
