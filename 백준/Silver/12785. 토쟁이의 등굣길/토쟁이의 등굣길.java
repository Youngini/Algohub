import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int a = DP(x, y);
        int b = DP(w - x + 1, h - y + 1);

        
        System.out.println((int)(((long)a * b) % MOD));
    }
    static int DP(int a, int b) {
            int[][] dp = new int[a + 1][b + 1];

            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b; j++) {
                    if (i == 1 || j == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }

            return dp[a][b];
        }
}
