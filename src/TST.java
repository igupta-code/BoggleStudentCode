// Isha Gupta
// Oct 8th 2024
public class TST{
    private static final char EMPTY = (char)0;
    private Node root;

    // Node class
    public class Node{
        private Node left, mid, right;
        private char letter;
        private boolean isWord;

        private Node(char letter){
            this.letter = letter;
        }

        private Node(){
            this.letter = EMPTY;
        }

        public boolean getIsWord(){
            return isWord;
        }

        public char getLetter(){
            return letter;
        }

    }

    public TST(){
        root = new Node();
    }

    public Node getRoot(){
        return root;
    }

    // Inserts a new string into the tst
    public void insert(String s){
        // If the root is null, insert the letter (only in case of top node)
        if (root.letter == 0){
            root.letter = s.charAt(0);
            if (s.length() == 1) root.isWord = true;
            // Recurse on the rest of the word as normal
            root.mid = insert(s, root.mid, 1);
        }
        else
            root = insert(s, root, 0);
    }

    public Node insert(String s, Node node, int index){
        // When you reach the end of the string, you are done inserting
        if(index == s.length())
            return null;

        // If the node is null, create a new node
        if(node == null){
            node = new Node(s.charAt(index));
        }

        // If at the end of the word and it's the correct node, return true
        if(index == s.length()-1 && s.charAt(index) == node.letter)
            node.isWord = true;
            // Compare current letter to node
            // If equals node, the correct letter is already at the tree(so index + 1)
        else if(s.charAt(index) == node.letter)
            node.mid = insert(s, node.mid, index + 1);
        else if(s.charAt(index) > node.letter)
            node.right = insert(s, node.right, index);
        else
            node.left = insert(s, node.left, index);
        return node;
    }

    public Node nextNode(Node node, char letter){
        if(node == null)
            return null;

        // If the node is correct, accept it by move onto the middle node, else recurse right or left
        if(letter == node.letter) {
            return node;
        }
        // Return the next node (either left or right in the tst)
        else if(letter > node.letter)
            return nextNode(node.right, letter);
        else
            return nextNode(node.left, letter);
    }

    // Checks if given word is in the TST
    public boolean lookUp(String s){
        return lookUp(s, root, 0);
    }



    public boolean lookUp(String s, Node node, int index){
        // Base: you are at the end of a branch and haven't found your word
        if(node == null)
            return false;

        // If the node is correct, accept it by move onto the middle node, else recurse right or left
        if(s.charAt(index) == node.letter){
            // If you are also at the end of the string, return if it's a word or not, otherwise continue recursing
            if(index == s.length() - 1)
                return node.isWord;
            else
                return lookUp(s, node.mid, index+1);
        }
        else if(s.charAt(index) > node.letter)
            return lookUp(s, node.right, index);
        else if(s.charAt(index) < node.letter)
            return lookUp(s, node.left, index);

        return false;
    }
}
