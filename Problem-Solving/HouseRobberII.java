import java.util.*;
class HouseRobberII {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        HouseRobberII obj = new HouseRobberII();
        System.out.println(obj.rob(arr));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int[] dp1 = Arrays.copyOfRange(dp, 0, dp.length);
        return Math.max( maxRob( 0, nums.length -2 , nums , dp), maxRob( 1, nums.length -1 , nums , dp1));
    }
   
    public static int maxRob(int start, int end, int[] arr, int[] dp){
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        if(start > end) return 0;
        if(dp[start] != -1) return dp[start];
        if(start == end) return dp[start] = arr[start];
        int rob = arr[start] + maxRob(start + 2, end, arr, dp);
        int notRob = maxRob(start + 1, end, arr, dp);
        return  dp[start] = Math.max(rob, notRob);

    }
}
