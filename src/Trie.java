// Isha Gupta
// Oct 8th 2024
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    // Inserts a new string into the trie
    public void insert(String s){
        insert(s, root);
    }

    public void insert(String s, Node root){
        // Base case: String is done (all added)
        if(s.isEmpty()){
            root.setWord(true);
            return;
        }

        // If the index of the array where the letter is, is empty
        if(root.getNext()[s.charAt(0)] == null){
            // If the index is empty then add the letter there
            root.getNext()[s.charAt(0)] = new Node();
        }
        insert(s.substring(1), root.getNext()[s.charAt(0)]);

    }

    // Returns true if the string already exists in the tree
    public boolean lookUp(String s){
        return lookUp(s, root);
    }
    public boolean lookUp(String s, Node root){
        // Base: if your string is empty, check if you are at a valid word
        if(s.isEmpty())
            return root.isWord();
        // Base: if the index of the next letter in next node is empty, return false
        if(root.getNext()[s.charAt(0)] == null)
            return false;


        return lookUp(s.substring(1), root.getNext()[s.charAt(0)]);
    }
}
