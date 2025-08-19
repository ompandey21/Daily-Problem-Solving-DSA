package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    class Node{
        int val;
        Node left, right;
    }

    private Node root;

    BinarySearchTree(int[] in){
        root = CreateTree(in, 0, in.length - 1);
    }

    private Node CreateTree( int[] in, int si, int ei){
        if(si > ei) return null;
        int mid = (si + ei)/2;

        Node nn = new Node();
        nn.val = in[mid];
        nn.left = CreateTree(in, si, mid -1);
        nn.right = CreateTree(in, mid+1, ei);
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
        s = " <-- " + nn.val + " --> ";
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

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root){

        if(root == null) return;
        System.out.print(root.val + " --> ");

        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root){

        if(root == null) return;
        

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " --> ");
    }
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node root){

        if(root == null) return;
        

        inOrder(root.left);
        System.out.print(root.val + " --> ");
        inOrder(root.right);
        
    }
    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node nn = queue.poll();
            System.out.print(nn.val+" --> ");
            if(nn.left != null) queue.add(nn.left);
            if(nn.right != null) queue.add(nn.right);

        }
        
    } 

}
