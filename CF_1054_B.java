import java.util.Scanner;

public class CF_1054_B {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();

                max = Math.max(arr[i], max);
                min = Math.min(arr[i], min);
            }

            int low = 0;
            int high = max - min;
            int ans = -1;

            while(low <= high){
                int mid = low + (high - low)/2;

                if(mid == 0){
                    high = mid -1;
                    ans = mid;
                }else low = mid + 1;
            }

            System.out.println(ans);


        }

       
    }
}
