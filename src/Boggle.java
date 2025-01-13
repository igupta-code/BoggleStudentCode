import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    public static TST dict;
    public String prefix = "";
    public static ArrayList<String> goodWords;

    // public static boolean[][] hasVisited;

    public static String[] findWords(char[][] board, String[] dictionary) {
        // Initialize variables
        goodWords = new ArrayList<String>();
        dict = new TST();

        // Add all the words in the dictionary to a tst
        for (String word : dictionary){
            dict.insert(word);
        }

        // DFS all the words in the board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                DFS(board, i, j, "", dict.getRoot());
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);

        for(String word: sol){
            System.out.println(word);
        }
        return sol;
    }

    public static void DFS(char[][] board, int row, int col, String prefix, TST.Node node){
        // Base case: out of bounds
        if(board.length <= row || board[0].length <= col || row < 0 || col < 0)
            return;
        // Base case: been here before
        if(board[row][col] == '0' || node == null)
            return;
        // You know it's in the TST so check if it's a valid word too
        if(node.getIsWord()) {
            // Add the current node to your prefix and add it to list of valid words
            goodWords.add(prefix + node.getLetter());
        }

        // Moves to the next spot in the TST in order to recurse
        TST.Node next = dict.nextNode(node, board[row][col]);

        // Create a temporary variable to hold board's value, and set board to hasVisited(indicated with 0)
        char holder = board[row][col];
        board[row][col] = '0';

        // Recurse in all four directions
        DFS(board, row - 1, col, prefix + holder, next);
        DFS(board, row + 1, col, prefix + holder, next);
        DFS(board, row, col - 1, prefix + holder, next);
        DFS(board, row, col + 1, prefix + holder, next);

        // Unmark the square as visited (give its original value back to it) so it recurses w/all possibilities
        board[row][col] = holder;
    }
}
