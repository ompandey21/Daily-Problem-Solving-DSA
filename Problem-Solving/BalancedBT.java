public class BalancedBT {
    
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    static class Result{
        boolean isbalance = true;
        int height = -1;
    }
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isbalance;
    }
    public static Result checkBalance(TreeNode root){
        if(root == null) return new Result();

        Result lres = checkBalance(root.left);
        Result rres = checkBalance(root.right);

        Result sres = new Result();
        sres.height = Math.max(lres.height, rres.height) + 1;
        sres.isbalance = (Math.abs(lres.height - rres.height) <= 1) && lres.isbalance && rres.isbalance;
        return sres;
    }
}
}
