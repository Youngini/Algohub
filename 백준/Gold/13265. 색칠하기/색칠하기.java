import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            System.out.println(possible(n, graph) ? "possible" : "impossible");
        }
    }

    public static boolean possible(int n, ArrayList<Integer>[] graph) {
        int[] color = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int start = 1; start <= n; start++) {
            if (color[start] != 0) continue;
            color[start] = 1;
            q.offer(start);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (color[next] == 0) {
                        color[next] = -color[cur];
                        q.offer(next);
                    } else if (color[next] == color[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}