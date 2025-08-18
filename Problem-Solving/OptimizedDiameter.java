public class OptimizedDiameter {

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
        class Result {
            int diameter = 0;
            int height = -1;
        }

        public int diameterOfBinaryTree(TreeNode root) {

            return findDiameter(root).diameter;

        }

        public Result findDiameter(TreeNode root) {
            if (root == null)
                return new Result();

            Result lres = findDiameter(root.left);
            Result rres = findDiameter(root.right);
            Result sres = new Result();
            sres.height = Math.max(lres.height, rres.height) + 1;
            int diameter = lres.height + rres.height + 2;
            sres.diameter = Math.max(Math.max(lres.diameter, rres.diameter), diameter);
            return sres;
        }
    }
}
