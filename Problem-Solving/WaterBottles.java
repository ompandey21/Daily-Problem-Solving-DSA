public class WaterBottles {
    class Solution {
        public int numWaterBottles(int n, int m) {
            return getSum(n, m, n);

        }

        public static int getSum(int n, int m, int sum) {
            if (n < m)
                return sum;

            return getSum(n / m + n % m, m, sum + n / m);
        }
    }
}
