import java.util.ArrayList;
import java.util.List;


public class BinaryTreeRightSide {

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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> li = new ArrayList<>();

            rightSide(root, li, 1);

            return li;
        }

        public static void rightSide(TreeNode root, List<Integer> ans, int curLevel) {
            if (root == null)
                return;

            if (curLevel > ans.size()) {
                ans.add(root.val);
            }

            rightSide(root.right, ans, curLevel + 1);
            rightSide(root.left, ans, curLevel + 1);

        }
    }
}
