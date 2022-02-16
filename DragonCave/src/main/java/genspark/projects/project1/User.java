package genspark.projects.project1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class User {

    private String name;
    private Scanner user;

    public User() {
        startInput();
    }

    // Getters
    public String getName() {
        return name;
    }

    public Integer getInput() {
        Integer userChoice = null;

        try {
            userChoice = user.nextInt();
        } catch (NullPointerException e) {
            System.out.println("Be brave; Enter a cave!\nYou didn't come all the way here for nothing!");
            getInput();
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid number");
            user.next();
            getInput();
        }

        return userChoice;
    }

    // Setters
    public void setName(String text) {
        this.name = text;
    }
    
    public void setName() {
        String text = user.nextLine();
        if (Pattern.matches("[a-zA-Z]++",text))
        this.name = text;
        else throw new InputMismatchException("Name must be composed only of letters.");
    }

    // class only methods
    public void startInput() {
        this.user = new Scanner(System.in);
    }

    public void endInput() {
        user.close();
        System.exit(0);
    }
}
