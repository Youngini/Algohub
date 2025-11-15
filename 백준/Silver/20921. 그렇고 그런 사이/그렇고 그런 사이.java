import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) dq.add(i);

        int[] ans = new int[n];
        int idx = 0;

        for (int len = n; len >= 1; len--) {
            if (k >= len - 1) {
                // 가장 뒤의 숫자를 앞으로 보내면 len-1개의 '그사이' 생성
                int x = dq.removeLast();
                ans[idx++] = x;
                k -= (len - 1);
            } else {
                // 그냥 앞의 숫자를 사용
                ans[idx++] = dq.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(" ");
        System.out.println(sb);
    }
}
