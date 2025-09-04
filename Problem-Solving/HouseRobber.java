import java.util.*;
class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        HouseRobber obj = new HouseRobber();
        System.out.println(obj.rob(arr));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxRob( 0, nums.length -1 , nums , dp);
    }
    public static int maxRob(int start, int end, int[] arr, int[] dp){
         
        if(start > end) return 0;
        if(dp[start] != -1) return dp[start];
        if(start == end) return dp[start] = arr[start];
        int rob = arr[start] + maxRob(start + 2, end, arr, dp);
        int notRob = maxRob(start + 1, end, arr, dp);
        return  dp[start] = Math.max(rob, notRob);

    }
}
