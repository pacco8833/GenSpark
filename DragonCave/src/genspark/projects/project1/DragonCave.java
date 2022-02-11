 package genspark.projects.project1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DragonCave {

    Scanner user = new Scanner(System.in);

    DragonCave() {
        introMsg();
        chooseCave();
        continueChooser();
        user.close();
        System.exit(0);
    }

    private void introMsg() {
        System.out.println();
        System.out.println("...You have entered a land full of dragons.");
        System.out.println("Many travellers have come to this land in search of the infamous dragons' treasure.");
        System.out.println( "Will you be the adventurer to find the correct dragon's cave,");
        System.out.println("...or will you perish like many adventurers before you?");
    }

    private void chooseCave() {
        System.out.println();
        System.out.println("Type and enter '1' to choose cave 1");
        System.out.println("Type and enter '2' to choose cave 2");
        System.out.print("Your Choice : ");

        try {
            int userChoice = user.nextInt();
            caver(userChoice);
        } catch (NullPointerException e) {
            System.out.println("Be brave; Enter a cave! You didn't come all the way here for nothing!");
            chooseCave();
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid number");
            user.next();
            chooseCave();
        } catch (Exception e) {
            System.out.println("Uncaught exception : " + e);
            chooseCave();
        }
    }

    private void continueChooser() {
        System.out.println();
        System.out.println("Do You continue?" + " Type and enter '1'");
        System.out.println("Do You turn back?" + " Type and enter '2'");
        System.out.print("Your Choice : ");

        try {
            int userChoice = user.nextInt();
            liver(userChoice);
        } catch (NullPointerException e) {
            System.out.println("You've got to make a choice! Don't just stand there!");
            continueChooser();
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid number");
            user.next();
            continueChooser();
        } catch (Exception e) {
            System.out.println("Uncaught exception : " + e);
            continueChooser();
        }
    }

    private void liver(int input) {
        System.out.println();
        switch (input) {
            case 1 -> die();
            case 2 -> live();
            default -> {
                System.out.println("Choice '" + input + "' does not exist!");
                continueChooser();
            }
        }
    }

    private void caver(int input) {
        System.out.println();
        switch (input) {
            case 1 -> wrongCave();
            case 2 -> rightCave();
            default -> {
                System.out.println("Cave '" + input + "' does not exist!");
                chooseCave();
            }
        }
    }

    private void wrongCave() {
        System.out.println("This is a creepy cave, man.");
        System.out.println("It's real dark and Spooky.");
        System.out.println("The Dark rocky cave seems to be getting more and more narrow as you continue.");
        System.out.println("As you descend further into the depths of the cave, it gets darker and darker.");
    }

    private void rightCave() {
        System.out.println("This is a sweet cave, man.");
        System.out.println("As you enter the cave, the sunlight beams and splits beautifully through the rocks above.");
        System.out.println("You find it extremely easy to navigate through the tunnels.");
        System.out.println("Water streams from a small waterfall across the chasm.");
        System.out.println("You can tell that others have been here, all obstacles are moved from your path.");
    }

    private void die() {
        System.out.println("Yeah, you died.");
        System.out.println("Nothing you did wrong, I mean sometimes the hero of the story dies.");
        System.out.println("You got eaten... It was gruesome. You did put up a fight though!");
        System.out.println("Let's be real though, it was a dragon; You didn't stand a chance.");
        System.out.println("I mean think about it, you just fought a dragon so, that's a cool death.");
    }

    private void live() {
        System.out.println("You decide to take a break and relax next to a completely not suspicious wall.");
        System.out.println("As you lean your body weight on the wall, it slides back revealing a hidden room!");
        System.out.println("You enter the room greeted figure who looks like Barney had a child with something from Dragon Tales.");
        System.out.println("You slay the dragon anyway since that's what you planned to do...");
        System.out.println("You collect your treasure and decide you need counselling.");
    }

    public static void main(String[] args) {
        new DragonCave();
    }
}