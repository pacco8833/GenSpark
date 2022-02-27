package genspark.projects.project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    
    private final ArrayList<Character> attempts = new ArrayList<>();
    private final ArrayList<Integer> allIndexes = new ArrayList<>();
    private final Scanner s = new Scanner(System.in);
    
    private WordBank bank = new WordBank();
    private String wordHash = "", randomWord;
    private boolean found = false;
    private int numWrong = 0, count = 0;
    private char hashCharacter = '_';

    Hangman() {
        this.randomWord = bank.getRandomWord();
        start();
    }

    Hangman(String word) {
        System.out.println("It seems you provided your own word, That's great.");
        this.randomWord = word;
        start();
    }

    public void setHashCharacter(String character) {
        this.hashCharacter = character.charAt(0);
    }

    public void finishHim() {
        s.close();
        System.exit(0);
    }

    public void start() {
        System.out.println("Hey Kyle, today, you're playing hangman.");
        wordHash = unhash(randomWord, hashCharacter + "", findAll(randomWord, "$"));
        getInput();
        finishHim();
    }

    public String unhash(String word, String letter, ArrayList<Integer> indexes) {
        String[] arr = new String[word.length()];
        Arrays.fill(arr, hashCharacter+"");
        for (Integer indexOfChar : indexes)
            arr[indexOfChar] = word.charAt(indexOfChar) + "";
        return Arrays.toString(arr);
    }

    public static ArrayList<Integer> findAll(String word, String letter) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int num = word.indexOf(letter);
        while (num != -1) {
            indexes.add(num);
            num = word.indexOf(letter, ++num);
        }
        return indexes;
    }

    private void findLetter(char letter) {
        int letterIndex = randomWord.indexOf(letter);
        String character = letter + "";
        
        if (letterIndex < 0) {
            thatsTheWrongLetter(character);
        } else {
            allIndexes.addAll(findAll(randomWord, character));
            wordHash = unhash(randomWord, character, allIndexes);
            testIfWordFound();
        }
    }

    private void testIfWordFound() {
        if (wordHash.indexOf(hashCharacter + "") == -1) {
            found = true;
            System.out.println("You found the secret word!!\n" + randomWord);
            System.exit(0);
        }
    }

    private void getInput() {
        char letter;
        while (!found) {
            command();
            System.out.print("Enter a Letter : ");
            try {
                letter = s.nextLine().toLowerCase().charAt(0);
                if (!attempts.contains(letter)) {
                    attempts.add(letter);
                    findLetter(letter);
                } else
                    System.out.println("You have already used that letter");
            } catch (NullPointerException e) {
                System.out.println("You didn't enter anything...");
                quitter();
            }
        }
    }

    private void quitter() {
        System.out.println("Would you like to stop guessing?");
        char response = s.nextLine().toLowerCase().charAt(0);
        if (response == 'y') {
            System.out.println("The Secret word was " + randomWord + ".\n...quitter.");
            finishHim();
        } else {
            System.out.println("This message will show if you do not enter anything into the field."
                    + "It is currently the only way to quit.");
        }
    }

    private void command() {
        String att = attempts.toString().substring(1, attempts.toString().length() - 1);
        String commandString = """

                Attempt %count
                Letters attempted :  %attempts
                Guess a letter in the secret word -> %hash
                """;
        commandString = commandString.replace("%count", ++count + "");
        commandString = commandString.replace("%attempts", att);
        commandString = commandString.replace("%hash", wordHash);
        System.out.println(commandString);
    }

    private void thatsTheWrongLetter(String character) {
        System.out.println("""
        '%letter' is not in the secret word
        """.replace("%letter", character));
        numWrong++;
        switch (numWrong) {
            case 1: {
                WrongLetter.head();
                break;
            }
            case 2: {
                WrongLetter.arm();
                break;
            }
            case 3: {
                WrongLetter.arms();
                break;
            }
            case 4: {
                WrongLetter.leg();
                break;
            }
            case 5: {
                WrongLetter.legs();
                break;
            }
            case 6: {
                WrongLetter.torso();
                break;
            }
            default: {
                WrongLetter.fullBody();
                System.out.println("You dead, fool!");
                System.out.println("The secret word was '" + randomWord + ".'");
                finishHim();
            }
        }
    }
}