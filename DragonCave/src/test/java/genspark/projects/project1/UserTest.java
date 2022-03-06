package genspark.projects.project1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserTest {

    User you = new User();

    
    @Test
    void fallBackName() {
        assertDoesNotThrow(() -> you.setName(), "Should not throw input mismatch");
    }

    @Disabled("Scanner blocks test completion")
    void testInputRetrieval() {
        assertNotEquals(null, you.getInput(), "make sure input cannot be null");
    }
    
    @Disabled("Scanner blocks test completion")
    void testStringScanning() {
        String name;
        you.setName("Henry");
        name = you.getName();
        assertEquals("Henry", name, "Name should be whatever we set it to.");
    }
}
