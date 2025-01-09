import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    public static TST dict = new TST();
    public static boolean[][] hasVisited;

    public static String[] findWords(char[][] board, String[] dictionary) {
        // Initialize variables
        hasVisited = new boolean[board.length][board[0].length];
        ArrayList<String> goodWords = new ArrayList<String>();
        String prefix = "";

        // Add all the words in the dictionary to a tst
        for (String word : dictionary){
            dict.insert(word);
        }

        // DFS all the words in the board



        // Compare the words to each other


        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void DFS(int row, int col, String prefix){

    }
}
