package DataStructures;

public class BinaryTreeClient {
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        // 10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false

        bt.display();
        bt.max();
        boolean f = bt.findNode(80);
        System.out.println("Maximum value in the tree: " + bt.max());
        System.out.println();

        if(f){
            System.out.println("Node found in the tree.");
        }else System.out.println("Node not found in the tree.");
        System.out.println("Tree Height:"+bt.height());

        bt.preOrder();

        System.out.println();

        bt.postOrder();
        System.out.println();

        bt.inOrder();

        System.out.println();
        bt.levelOrder();
    }
}
