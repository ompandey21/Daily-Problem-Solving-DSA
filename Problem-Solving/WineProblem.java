public class WineProblem {
    public static void main(String[] args) {
        int [] wine = {2, 3, 5, 1 ,4};
        int n = wine.length;
        int[][] dp = new int[n][n];
        System.out.println(maximum_profit(wine, 0, n - 1, 1, dp));
    }
    public static int maximum_profit(int[] wine, int i, int j, int year, int[][] dp){
        if (i > j) {
            return 0;
        }
        if(dp[i][j] != 0) return dp[i][j];
        int fs = wine[i]*year + maximum_profit(wine, i + 1, j, year + 1, dp);
        int ls = wine[j]*year + maximum_profit(wine, i, j - 1, year + 1, dp);
        return dp[i][j] = Math.max(fs, ls);
    }



}
