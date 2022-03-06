package genspark.projects.project3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class BankTest {
    WordBank bank = new WordBank();

    @Test
    public void shouldAnswerWithTrue() {
        assertNotNull(bank.getAllWords(), "Proves that the word bank is not blank");
    }

    @Test
    public void addNewWordsToBank() {
        ArrayList<String> list = bank.getAllWords();
        String newWord = "Autumn";

        bank.addWord(newWord);

        if (list.contains(newWord)) {
            assertEquals(list.size(), bank.getAllWords().size(),
                    "Nothing should change if the word is already in here");
        } else {
            assertNotEquals(list.size(), bank.getAllWords().size(), "There is a new word, the list is different.");
        }
    }
}
