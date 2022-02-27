package genspark.projects.project2;


import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserIn {

    String name = null;
    Scanner user;

    // initial scanner
    public UserIn() {
        introduce();
    }

    // only possible on a replay
    public UserIn(String name) {
        this.name = name;
    }

    public void setIn(InputStream s){
        this.user = new Scanner(s);
    }
    
    public void setName() {
        System.out.print("Please enter your name : ");
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
    
    public void setName(String name) {
        if (name != null && !name.isBlank())
        this.name = name;
    }
    
    public Integer getNumber() {
        int guess;
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
               NumberGuesser guesser = new NumberGuesser();
               break;
            }
            case "c", "C": {
                NumberGuesser guesser = new NumberGuesser();
            }
            case "m", "M": {
                getUserSuppliedMax();
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
    
    private void introduce() {
        String intro = """
                Hey there, I've got a number guessing game for ya.
                First, I'm gonna need a name to call you by.
                """;
        System.out.println(intro);
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
                NumberGuesser guesser = new NumberGuesser();
            } else {
                System.out.println("You entered a number lower than 10, defaulting to 20.");
                NumberGuesser guesser = new NumberGuesser();
            }
        } catch (InputMismatchException e) {
            System.out.println("You didn't enter a number.\nDefaulting to exit");
            endProgram();
        }
    }
}
