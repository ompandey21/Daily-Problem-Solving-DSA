import java.io.*;
import java.util.*;

public class ThreeWaySplit {

    public static void solve(BufferedReader br) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + a[i];
            }

            boolean found = false;
            for (int l = 1; l < n && !found; l++) {
                for (int r = l + 1; r < n; r++) {
                    int s1 = normalize(prefix[l]);
                    int s2 = normalize(prefix[r] - prefix[l]);
                    int s3 = normalize(prefix[n] - prefix[r]);

                    if ((s1 == s2 && s2 == s3) ||
                        (s1 != s2 && s2 != s3 && s1 != s3)) {
                        System.out.println(l + " " + r);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("0 0");
            }
        }
    }

    private static int normalize(long val) {
        return (int)((val % 3 + 3) % 3); // ensures result is 0, 1, or 2
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solve(br);
    }
}
