import java.util.Scanner;

public class CF_Homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            int m = sc.nextInt();
            String b = sc.next();
            String chance = sc.next();

            for (int i = 0; i < m; i++) {
                if (chance.charAt(i) == 'V') {
                    a = b.charAt(i) + a;
                } else
                    a = a + b.charAt(i);
            }
            System.out.println(n+m);
            System.out.println(a);
        }
        sc.close();
    }
}
