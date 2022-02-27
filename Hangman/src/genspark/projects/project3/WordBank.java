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

    // opens a file filled with random words
    private void loadRandomWords() {
        // scan all the words in the file
        try (Scanner file = new Scanner(namedFile)) {
            String line;
            while (file.hasNextLine()) {
                // get line from file
                line = file.nextLine();
                // add line to possible random words
                wordBank.add(line);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("Word Bank file has either been deleted or moved.");
        }
    }

    public ArrayList<String> getAllWords() {
        return wordBank;
    }

    // returns a random word from the given arraylist
    public String getRandomWord() {
        Random rand = new Random();
        return wordBank.get(rand.nextInt(wordBank.size()));
    }

    public void begForAWord() {
        Scanner s = new Scanner(System.in);
        String usersWord, userResponse;
        System.out.println("Would you like to add a word to our random word list?");
        // make everything lowercase, remove trailing spaces
        userResponse = s.nextLine();
        if (userResponse.matches("a-zA-Z")) {
            usersWord = userResponse;
            respondToWord(usersWord);
        }
        s.close();
    }

    private void respondToWord(String word) {
        if (word.length() > 4 && !wordBank.contains(word)) {
            // add the word to our random word bank
            addToList(word);
        } else if (wordBank.contains(word)) {
            System.out.println("Thanks, but our word bank already has that word.");
        } else {
            System.out.println("Thanks, but that word is too short.");
        }
    }

    // append the new word to file, add a newline after
    public void addToList(String word) {
        String newLine = "\n";
        try (FileWriter fw = new FileWriter(namedFile, true)) {
            fw.write(word + newLine);
        } catch (Exception e) {
            System.out.println("Something Went wrong man.");
        }
    }
}
