// Isha Gupta
// Oct 8th 2024
public class Node {
    private boolean isWord;
    private Node[] next;


    public Node(){
        this.isWord = false;
        this.next = new Node[255];
    }


    public boolean isWord(){
        return isWord;
    }

    public void setWord(boolean word){
        isWord = word;
    }

    public Node[] getNext(){
        return next;
    }


}
