import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    public static TST dict,
            foundWords;
    public String prefix = "";
    public static ArrayList<String> goodWords;

    // public static boolean[][] hasVisited;

    public static String[] findWords(char[][] board, String[] dictionary) {
        // Initialize variables
        goodWords = new ArrayList<String>();
        dict = new TST();
        foundWords = new TST();

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
        if(node.getLetter() != board[row][col])
            node = dict.nextNode(node.getMid(), board[row][col]);
        // Base case: been here before or if word doesn't exit in tst (node will = null)
        if(board[row][col] == '0' || node == null)
            return;




        // Moves to the next spot in the TST in order to recurse
        //TST.Node next = dict.nextNode(node, board[row-1][col]);

        // Create a temporary variable to hold board's value, and set board to hasVisited(indicated with 0)
        char holder = board[row][col];
        board[row][col] = '0';

        // Recurse in all four directions

        DFS(board, row, col - 1, prefix + holder, node);
        DFS(board, row, col + 1, prefix + holder, node);
        DFS(board, row - 1, col, prefix + holder, node);
        DFS(board, row + 1, col, prefix + holder, node);

        // Unmark the square as visited (give its original value back to it) so it recurses w/all possibilities
        board[row][col] = holder;
    }
}
