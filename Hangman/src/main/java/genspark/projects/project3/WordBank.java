package genspark.projects.project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordBank {
    // List of words in words.txt
    private final ArrayList<String> wordBank = new ArrayList<>();
    // Location of word list
    private final File namedFile = new File("src\\words.txt");

    WordBank() {
        loadRandomWords();
    }

    public ArrayList<String> getAllWords() {
        return wordBank;
    }

    // returns a random word from the given arraylist
    public String getRandomWord() {
        Random rand = new Random();
        return wordBank.get(rand.nextInt(wordBank.size()));
    }

    // opens a file filled with random words
    private void loadRandomWords() {
        // scan all the words in the file
        try (Scanner file = new Scanner(namedFile)) {
            String line;
            while (file.hasNextLine()) {
                // get line from file
                line = file.nextLine();
                // add line to possible random words
                wordBank.add(line.toLowerCase());
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("Word Bank file has either been deleted or moved.");
        }
    }

    public void begForAWord() {
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to add a word to our random word list?");
        String userResponse = s.nextLine();
        s.close();
        addWord(userResponse);
    }

    private void disqualify(String word) {
        if (word == null || word.isBlank()) {
            System.out.println("Thanks, but you didn't enter anything.");
            System.exit(0);
        } else {
            word = word.toLowerCase();
            if (wordBank.contains(word)) {
                System.out.println("Thanks, but our word bank already has that word.");
                System.exit(0);
            }
            if (word.length() <= 4) {
                System.out.println("Thanks, but that word is too short.");
                System.exit(0);
            }
        }
    }

    public void addWord(String word) {
        disqualify(word);
        String newWord = toTitleCase(word);
        try (FileWriter fw = new FileWriter(namedFile, true)) {
            fw.write(newWord + "\n");
            System.out.println("Thanks! '" + newWord.trim() + "' has been added to the wordbank!");
        } catch (Exception e) {x
            System.out.println("Something went wrong man.");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private String toTitleCase(String word) {
        String upperCaseFirstLetter = (word.charAt(0) + "").toUpperCase().trim();
        String lowerCaseLetters = word.substring(1).toLowerCase().trim();
        return upperCaseFirstLetter + lowerCaseLetters;
    }
}
