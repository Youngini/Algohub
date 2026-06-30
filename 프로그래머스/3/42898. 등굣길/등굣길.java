class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        
        // 물웅덩이 표시
        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;   // [세로][가로]
        }
        
        // 시작점
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;   // 시작점 스킵
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;   // 물웅덩이는 0
                    continue;
                }
                // 위 + 왼쪽 (경계는 0이라 자동 처리)
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }
        
        return dp[n][m];
    }
}