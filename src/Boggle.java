import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();
        ArrayList<String> boardWords = new ArrayList<String>();

        // BFS all the words in the board


        // Add all the words in the dictionary to a tst

        // Compare the words to each other

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
}
