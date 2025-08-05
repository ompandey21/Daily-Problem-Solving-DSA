package DataStructures;

import java.util.Scanner;

public class BinaryTree {
    class Node{
        int val;
        Node left, right;


    }
    Scanner sc = new Scanner(System.in);
    private Node root;
    


    public BinaryTree() {
        root = CreateTree();
    }
    private Node CreateTree(){
        int data = sc.nextInt();
        Node nn = new Node();
        nn.val = data;
        boolean hlc = sc.nextBoolean(); // has left child
        if(hlc){    
            nn.left = CreateTree();
        }
        boolean hrc = sc.nextBoolean(); // has right child
        if(hrc){
            nn.right = CreateTree();
        }
        return nn;
    }
    public void display() {
        display(root);
    }
    public int max(){
        return max(root);
    }
    private int max(Node nn){
        if(nn == null){
            return 0;   
        }
        int leftMax = max(nn.left);
        int rightMax = max(nn.right);
        return Math.max(leftMax, Math.max(rightMax, nn.val));
    }
    private void display(Node nn){
        if(nn == null){
            return;
        }
        String s = "";
        s = " <--" + nn.val + "--> ";
        if(nn.left != null){
            s = nn.left.val + s;
        }
        if(nn.right != null){
            s = s + nn.right.val;
        }
        System.out.println(s);
        display(nn.left);
        display(nn.right);
    }
    public boolean findNode(int data) {
        return findNode(root, data);
    }
    private boolean findNode(Node nn, int data) {
        if(nn == null) {
            return false;
        }
        if(nn.val == data) {
            return true;
        }
        boolean leftFound = findNode(nn.left, data);
        boolean rightFound = findNode(nn.right, data);
        return leftFound || rightFound;
    }
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null) return 1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
