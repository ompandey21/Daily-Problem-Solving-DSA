import java.util.*;

public class CF_Journey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = { a, b, c };
            int k = a + b + c;

            long res =  (n / k) * 3;
            n = n % k;
            int idx = 0;
            while (n > 0) {
                n -= arr[idx++ % 3];
                res++;
            }
            System.out.println(res);
        }
        sc.close();

    }
}
