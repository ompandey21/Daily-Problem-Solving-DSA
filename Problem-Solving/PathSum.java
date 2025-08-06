public class PathSum {
    // 112 leetcode

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null)
                return false;
            return isPossible(root, targetSum);
        }

        public boolean isPossible(TreeNode root, int target) {
            if (root == null)
                return false;

            if (root.left == null && root.right == null)
                return target - root.val == 0;

            boolean left = isPossible(root.left, target - root.val);
            boolean right = isPossible(root.right, target - root.val);

            return left || right;
        }
    }
}
