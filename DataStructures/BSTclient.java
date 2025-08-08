package DataStructures;

public class BSTclient {
    public static void main(String[] args) {
        int[] in = { 10, 20, 30, 40, 50, 60, 70, 80};

        BinarySearchTree bst = new BinarySearchTree(in);
        bst.display();
    }
}
