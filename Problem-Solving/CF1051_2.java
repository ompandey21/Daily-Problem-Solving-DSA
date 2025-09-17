import java.io.*;
import java.util.*;

public class CF1051_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            List<Integer>[] g = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
            int[] indeg = new int[n + 1];
            
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                
                if (x >= y) {
                    g[u].add(v);
                    indeg[v]++;
                } else {
                    g[v].add(u);
                    indeg[u]++;
                }
            }
            
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) if (indeg[i] == 0) q.add(i);
            
            int[] p = new int[n + 1];
            int rank = n;
            
            while (!q.isEmpty()) {
                int u = q.poll();
                p[u] = rank--;
                for (int w : g[u]) if (--indeg[w] == 0) q.add(w);
            }
            
            for (int i = 1; i <= n; i++) {
                if (i > 1) out.append(" ");
                out.append(p[i]);
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}
