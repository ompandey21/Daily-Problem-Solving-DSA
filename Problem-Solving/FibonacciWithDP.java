public class FibonacciWithDP {
    public static void main(String[] args) {
        int n = 50;

        int[] dp = new int[n+1];
        int res = Fib(n , dp);
        System.out.println(res);

    }
    public static int Fib( int n , int[] dp){
        if(dp[n] != 0) return dp[n];
        if( n == 0 || n == 1){
            return n;
        }
        int f1 = Fib(n - 1, dp);
        int f2 = Fib(n - 2, dp);
        return dp[n] = f2 + f1;
    }
}
