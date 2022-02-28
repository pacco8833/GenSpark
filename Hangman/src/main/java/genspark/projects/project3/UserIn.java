package genspark.projects.project3;

import java.io.InputStream;
import java.util.Scanner;

public class UserIn {

    String name = null;
    Scanner user;

    // initial scanner
    public UserIn() {
        introduce();
        if (user == null)
            user = new Scanner(System.in);
    }

    // only possible on a replay
    public UserIn(String name) {
        this.name = name;
        introduce();
    }

    // needed for testing
    public UserIn(InputStream s, String name) {
        UserIn you = new UserIn();
        you.name = name;
        you.setIn(s);
    }

    private void introduce() {
        String intro = null;

        if (name == null) {
            intro = """
                    Hey there, we are playing Hangman!
                    """;
        } else {
            intro = """
                    Welcome Back %name.
                    We're still playing Hangman!
                    """;
            intro = intro.replace("%name", this.name);
        }

        System.out.println(intro);
    }

    public void setIn(InputStream s) {
        this.user = new Scanner(s);
    }

    public void setName() {
        System.out.println("First, I'm gonna need a name to call you by.");
        System.out.print("Please enter your name : ");
        name = user.nextLine();
        if (name == null || name.isBlank()) {
            System.out.println("Don't be Shy...\n");
            setName();
        } else {
            String $1 = (name.charAt(0) + "").toUpperCase();
            name = $1 + name.substring(1).toLowerCase();
            System.out.println();
        }
    }

    public void setName(String name) {
        if (name != null && !name.isBlank())
            this.name = name;
    }

    public char getLetter() {
        String line;
        char guess;
        System.out.print("Guess Your Letter : ");
        try {
            line = user.nextLine();
            guess = line.toLowerCase().charAt(0);
            System.out.println();
            return guess;
        } catch (StringIndexOutOfBoundsException e) {
            String str = """
                    You did not enter anything.
                    Try entering a guess this time.
                    """;
            System.out.println(str);
            user.nextLine();
            return getLetter();
        }
    }

    public void replay() {
        String response;
        interrogate();
        response = user.nextLine();
        evaluateResponse(response);
    }

    private void interrogate() {
        String text = """

                If you want play again %name, that's your choice, and I respect it.
                Type and Enter 'Y' for Yes; Type and enter 'N' for No

                'Yes' will restart the game;
                'No' will Exit the game;

                No Pressure.

                """;
        text = text.replace("%name", name);
        System.out.print(text + "Your Response : ");
    }

    private void evaluateResponse(String response) {
        response = (response.charAt(0) + "").toLowerCase();
        switch (response) {
            case "n": {
                endProgram();
            }
                break;
            case "y": {
                new Hangman();
                break;
            }
            default: {
                replay();
            }
        }
    }

    public void endProgram() {
        user.close();
        System.exit(0);
    }

    public String getName() {
        return name;
    }

    public void quit(String word) {
        System.out.println("Would you like to stop guessing?");
        char response = user.nextLine().toLowerCase().charAt(0);
        if (response == 'y') {
            System.out.println("The Secret word was '" + word + "''.\n...quitter.");
            endProgram();
        } else {
            System.out.println("This message will show if you do not enter anything into the field."
                    + "It is currently the only way to quit.");
        }
    }
}
