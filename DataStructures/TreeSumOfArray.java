package DataStructures;

// LeetCode 2221
public class TreeSumOfArray {
    class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] res = new int[n-1];
        int idx = 0;
        for(int i = 1; i< n; i++){
            res[idx++] = (nums[i] + nums[i-1]) % 10; 
        }
        return triangularSum(res);
    }
}
}
