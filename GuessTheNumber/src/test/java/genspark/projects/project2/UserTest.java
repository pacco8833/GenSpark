package genspark.projects.project2;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class UserTest {
    UserIn user = null;

    @BeforeEach
    void startTest() {
        String str = """
                Carl
                Carl
                Carl
                Carl
                Carl
                """;

        InputStream in = new ByteArrayInputStream(str.getBytes());

        user = new UserIn();
        user.setIn(in);
        user.setName();

        try {
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void differentNames() {
        UserIn user2 = new UserIn("Charlie");
        String carl = user2.getName();
        String msg = """
                The two  names should not be equal,
                'user2' should be 'Charlie';
                'user' should be Carl.
                """;
        assertNotEquals(carl, user.getName(), msg);
    }

    @AfterEach
    void closeScanner() {
        user.endProgram();
    }
}
