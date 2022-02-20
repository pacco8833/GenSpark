package genspark.projects.project1;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserIn {

    String name = null;
    Scanner user;

    // inital scanner
    public UserIn() {
        introduce();
    }

    // only possible on a replay
    public UserIn(String name) {
        this.name = name;
    }

    protected void setIn(InputStream s){
        this.user = new Scanner(s);
    }

    private void introduce() {
        String intro = """
                Hey there, I've got a number guessing game for ya.
                First, I'm gonna need a name to call you by.
                """;
        System.out.println(intro);
    }

    public void setName() {
        System.out.print("Enter your name : ");
        name = user.nextLine();
        if (name.isBlank()) {
            System.out.println("Don't be Shy...\n");
            setName();
        } else {
            String $1 = (name.charAt(0) + "").toUpperCase();
            name = $1 + name.substring(1).toLowerCase();
            System.out.println();
        }
    }

    public Integer getNumber() {
        Integer guess;
        System.out.print("Guess Your Number : ");
        try {
            guess = user.nextInt();
            System.out.println();
            return guess;
        } catch (InputMismatchException e) {
            String str = """
                    You did not  enter a number.
                    Try entering a number this time.
                    """;
            System.out.println(str);
            user.nextLine();
            return getNumber();
        }
    }

    public void replay() {
        String response;
        interrogate();
        response = user.nextLine();
        evaluateResponse(response);
    }

    public void evaluateResponse(String response) {
        response = (response.charAt(0) + "");
        switch (response) {
            case "n", "N": {
                endProgram();
            }
                break;
            case "y", "Y": {
                new NumberGuesser(name);
                break;
            }
            case "c", "C": {
                setName();
                new NumberGuesser(name);
            }
            case "m", "M": {
                getUserSuppliedMax();
            }
            default: {
                replay();
            }
        }
    }

    private void interrogate() {
        user.nextLine();

        String text = """
                If you want play again %name, that's your choice, and I respect it.
                Type and Enter 'Y' for Yes; Type and enter 'N' for No

                'Yes' will restart the game;
                'No' will Exit the game;
                'Change' will change your name and play again;
                'Max' will change the maximum number and play again.

                No Pressure.

                """;
        text = text.replace("%name", name);
        System.out.print(text + "Your Response : ");
    }

    private void getUserSuppliedMax() {
        System.out.println("What number would you like to max out to?");
        try {
            System.out.print("Max (must be bigger than 10) : ");
            int num = user.nextInt();
            if (num >= 10) {
                new NumberGuesser(name, num);
            } else {
                System.out.println("You entered a number lower than 10, defaulting to 20.");
                new NumberGuesser(name);
            }
        } catch (InputMismatchException e) {
            System.out.println("You didn't enter a number.\nDefaulting to exit");
            endProgram();
        }
    }

    public void endProgram() {
        user.close();
        System.exit(0);
    }

    public String getName() {
        return name;
    }
}
