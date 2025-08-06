public class SumRootToLeafNumbers {
    // Leetcode 129

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
        public int sumNumbers(TreeNode root) {

            return sum(root, 0);

        }

        public static int sum(TreeNode root, int num) {
            if (root == null)
                return 0;

            if (root.left == null && root.right == null) {

                return num * 10 + root.val;
            }

            int a = sum(root.left, num * 10 + root.val);
            int b = sum(root.right, num * 10 + root.val);

            return a + b;

        }
    }
}
