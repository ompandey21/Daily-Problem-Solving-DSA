package DP;

public class MAtrixCahinMultiplication {
    public static void main(String [] args){
        int[] arr = { 4, 2, 3, 5, 1 } ;
        int[][] dp = new int[arr.length][arr.length];
        System.out.println(mcm(arr, 0, arr.length - 1, dp));
    }
    public static int mcm(int[] arr, int st, int end, int[][] dp){
        int ans = Integer.MAX_VALUE;
        if(dp[st][end] != 0) return dp[st][end];
        for(int i = st + 1; i < end; i++){
            int first = mcm(arr, st, i, dp);
            int last =  mcm(arr, i, end, dp);
            int self = arr[st] * arr[i] * arr[end];

            ans = Math.min(ans, first + last + self);

        }
        return dp[st][end] =  ans;
    }
}


