package genspark.projects.project1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    private final Random rand = new Random();
    private final Scanner user = new Scanner(System.in);
    private String name;
    private int number;

    NumberGuesser() {
        startGame();
        userGuess();
        endItAll();
    }


    private void startGame() {
        System.out.println("Hey there, I've got a number guessing game for ya.");
        //create a random number
        number = rand.nextInt(21);
        System.out.println("First bro, I'm gonna need your identity");
        setName();
        //print out challenge to the user
        System.out.println("Hey " + name + ", Guess the secret number.\nIt's between 0 and 20.");
        System.out.println();
    }

    private void setName() {
        System.out.print("Enter your name : ");
        try {
            name = user.nextLine();
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Quit playing around, dude. I need your identity");
            setName();
        }
        System.out.println();
    }

    private void userGuess() {
        int count = 0;
        int guess;

        try {
            do {
                System.out.print("Guess Your Number  : ");
                guess = user.nextInt();
                ++count;
                //number is correct
                if (guess == number) {
                    System.out.println("That's exactly it, "+name+".");
                    System.out.println("You figured it out in " + count + " attempts");
                    System.out.println();
                    replay();
                }
                //received negative number
                if (guess < 0) {
                    System.out.println("It's not a negative, man. The number is greater than 0");
                }
                //number is greater than 20
                if (guess > 20) {
                    System.out.println("That's way too high, bro. The number is less than 20");
                }
                //high guess
                if (guess > number) {
                    System.out.println("That number is too high");
                }
                //low guess
                if (guess < number) {
                    System.out.println("That number is too low");
                }
                System.out.println();
            } while (guess != number);
        } catch (Exception ex) {
            System.out.println(ex);
            user.next();
            userGuess();
        }

    }

    private void replay() {
        System.out.println("If you wanna play again, that's totally your choice, and I respect it.");
        System.out.println("Type and Enter Y for Yes, Type and enter N for No");
        System.out.println();
        System.out.print("Your Response : ");
        user.next();
        try {
            String response = user.nextLine();
            if (response.equalsIgnoreCase("y")) {
                new NumberGuesser();
            }
        } catch (Exception ex) {
            System.out.println("You messed up "+name+", I get it. Don't enter wrong stuff next time though.");
            System.out.println(ex);
            user.next();
            replay();
        }
    }

    private void endItAll() {
        System.out.println("Wanna leave?");
        System.out.println("Type and Enter Y for Yes, Type and enter N for No");
        System.out.print("Your Response : ");
        try {
            if (user.nextLine().equalsIgnoreCase("y"))
                System.exit(0);
            new NumberGuesser();
        } catch (Exception ex) {
            System.out.println(ex);
            user.next();
            endItAll();
        }
    }
    public static void main(String[] args) {
        new NumberGuesser();
    }
}
