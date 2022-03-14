package genspark.projects.project3;

import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {

    // data
    private final ArrayList<Character> attemptedChars = new ArrayList<>();
    private final ArrayList<Integer> allIndexes = new ArrayList<>();
    // objects
    private final UserIn you = new UserIn();
    private final WordBank bank = new WordBank();
    private final String randomWord;
    private String wordHash = "";
    // primitives
    private int numWrong = 0, count = 0;
    private char hashCharacter = '_';

    Hangman() {
        this.randomWord = bank.getRandomWord();
    }

    Hangman(String word) {
        System.out.println("It seems you provided your own word, That's great.");
        this.randomWord = word;
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

    public Character getHashCharacter() {
        return hashCharacter;
    }

    public void setHashCharacter(String character) {
        this.hashCharacter = character.charAt(0);
    }

    public void start() {
        you.setName();
        wordHash = unhash(randomWord, findAll(randomWord, "$"));
        getInput();
        finishHim();
    }

    public String unhash(String word, ArrayList<Integer> indexes) {
        String[] arr = new String[word.length()];
        Arrays.fill(arr, hashCharacter + "");
        for (Integer indexOfChar : indexes)
            arr[indexOfChar] = word.charAt(indexOfChar) + "";
        return Arrays.toString(arr);
    }

    private void findLetter(char letter) {
        int letterIndex = randomWord.indexOf(letter);
        String character = letter + "";

        if (letterIndex < 0) {
            thatsTheWrongLetter(character);
        } else {
            allIndexes.addAll(findAll(randomWord, character));
            wordHash = unhash(randomWord, allIndexes);
        }
    }

    private void testIfWordFound() {
        if (!wordHash.contains(hashCharacter + "")) {
            String finishedStr = """
                    You found the secret word, %name!
                    Nice One!
                    '%random'
                    """;
            finishedStr = finishedStr.replace("%name", you.getName());
            finishedStr = finishedStr.replace("%random", randomWord);
            System.out.println(finishedStr);
        }
        getInput();
    }

    private void getInput() {
        char letter;
        command();
        try {
            letter = you.getLetter();
            if ((letter + "").isBlank()) {
                you.quit(randomWord);
            } else if (attemptedChars.contains(letter)) {
                System.out.println("You have already used that letter");
            } else {
                attemptedChars.add(letter);
                findLetter(letter);
                testIfWordFound();
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("You didn't enter anything...");
            you.quit(randomWord);
        }
    }

    private void command() {
        String att = attemptedChars.toString().substring(1, attemptedChars.toString().length() - 1);
        String commandString = """

                %name's Attempt # %count
                Letters attempted :  %attempts
                Guess a letter in the secret word -> %hash
                """;
        commandString = commandString.replace("%name", you.getName());
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
            case 1 -> WrongLetter.head();
            case 2 -> WrongLetter.arm();
            case 3 -> WrongLetter.arms();
            case 4 -> WrongLetter.leg();
            case 5 -> WrongLetter.legs();
            case 6 -> WrongLetter.torso();
            default -> {
                WrongLetter.fullBody();
                System.out.println("You dead, fool!");
                System.out.println("The secret word was '" + randomWord + ".'");
                finishHim();
            }
        }
    }

    public void finishHim() {
        bank.begForAWord();
        you.replay();
        System.exit(0);
    }
}