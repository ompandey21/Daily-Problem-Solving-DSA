
import java.util.*;

public class CF1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            long[] a = new long[n];
            int[] b = new int[k];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < k; i++) {
                b[i] = sc.nextInt();
            }
            
            Arrays.sort(a);
            reverse(a);
            Arrays.sort(b);
            
            long res = 0;
            for (long x : a) res  += x;
            
            int i = 0;
            for (int x : b) {
                if (i + x - 1 >= n)break;
                i += x - 1;
                res -=a[i];
                i++;
            }
            
            System.out.println(res);
        }
    }
     public static void reverse(long[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            long tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}

