import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();

            findPaths(root, targetSum, 0, new ArrayList<>(), ans);
            return ans;
        }

        public static void findPaths(TreeNode root,
                int target,
                int sum,
                List<Integer> temp,
                List<List<Integer>> ans) {

            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                if (sum + root.val == target) {
                    temp.add(root.val);
                    ans.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                }
                return;
            }

            temp.add(root.val);
            sum += root.val;
            findPaths(root.left, target, sum, temp, ans);

            findPaths(root.right, target, sum, temp, ans);
            sum -= root.val;
            temp.remove(temp.size() - 1);

        }
    }
}
