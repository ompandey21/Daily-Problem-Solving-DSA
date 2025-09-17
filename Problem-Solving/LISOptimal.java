public class LISOptimal {
    public static void main(String[] args){

    }
    public static int LIS(int[] arr){
        int[] dp = new int[arr.length];

        int len = 1;
        dp[0] = arr[0];
        for(int i = 0; i<dp.length; i++){
            if( arr[i] > dp[len-1]){
                dp[len] = arr[i];
                len++;
            } else {
                int idx = BinarySearch( dp, 0, len-1, arr[i]);
                dp[idx] = arr[i];
            }
        }
        return len;
    }
    public static int BinarySearch(int[] arr, int high, int low, int val){
        int ans = 0;
        while (low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] < val) low = mid + 1;
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}
