import java.util.*;

public class CF_TheNether {
    static Scanner sc = new Scanner(System.in);

    static void flushln() {
        System.out.println();
        System.out.flush();
    }

    static long ask(int x, List<Integer> S) {
        System.out.print("? " + x + " " + S.size() + " ");
        for (int v : S) System.out.print(v + " ");
        flushln();

        if (!sc.hasNextLong()) System.exit(0);
        long ans = sc.nextLong();
        if (ans == -1) System.exit(0);
        return ans;
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();

            List<Integer> all = new ArrayList<>();
            for (int i = 1; i <= n; i++) all.add(i);

            int[] len = new int[n + 1];
            Arrays.fill(len, 1);

            for (int x = 1; x <= n; x++) {
                long v = ask(x, all);
                len[x] = (int) v;
            }

            int s = 1, L = len[1];
            for (int i = 2; i <= n; i++) {
                if (len[i] > L) {
                    L = len[i];
                    s = i;
                }
            }

            List<List<Integer>> bl = new ArrayList<>();
            for (int i = 0; i <= L; i++) bl.add(new ArrayList<>());
            for (int v = 1; v <= n; v++) {
                if (len[v] >= 1 && len[v] <= L) {
                    bl.get(len[v]).add(v);
                }
            }

            List<Integer> path = new ArrayList<>();
            path.add(s);
            boolean[] used = new boolean[n + 1];
            used[s] = true;
            int cur = s;

            for (int need = L - 1; need >= 1; need--) {
                int nextv = -1;
                for (int v : bl.get(need)) {
                    if (used[v]) continue;
                    List<Integer> S = Arrays.asList(cur, v);
                    long r = ask(cur, S);
                    if (r == 2) {
                        nextv = v;
                        break;
                    }
                }
                if (nextv == -1) {
                    System.out.print("! 1 " + s + " ");
                    flushln();
                    continue;
                }
                path.add(nextv);
                used[nextv] = true;
                cur = nextv;
            }

            System.out.print("! " + path.size() + " ");
            for (int v : path) System.out.print(v + " ");
            flushln();
        }
    }
}
