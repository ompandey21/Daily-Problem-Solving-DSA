package DataStructures;

public class BinaryTreeClient {
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.display();
        bt.max();
        boolean f = bt.findNode(80);
        System.out.println("Maximum value in the tree: " + bt.max());
        System.out.println();

        if(f){
            System.out.println("Node found in the tree.");
        }else System.out.println("Node not found in the tree.");
        System.out.println("Tree Height:"+bt.height());
    }
}
