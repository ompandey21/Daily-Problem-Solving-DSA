public class FlipEquivalentTree { 
    // 951 leetcode
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isFlipEq(root1, root2);
    }
    public static boolean isFlipEq(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val) return false;

        boolean leftS = isFlipEq( root1.left , root2.right );
        boolean rightS = isFlipEq( root1.right , root2.left );
        boolean leftE = isFlipEq( root1.left , root2.left );
        boolean rightE = isFlipEq( root1.right , root2.right );

        return (leftS && rightS) || (leftE && rightE);
    }
}
}
