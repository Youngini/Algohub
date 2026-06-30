class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 왼쪽 끝: 위쪽만 가능
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    // 오른쪽 끝: 왼쪽 위만 가능
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    // 중간: 둘 중 큰 값
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        // 마지막 층에서 최댓값
        int answer = 0;
        for (int v : dp[n - 1]) answer = Math.max(answer, v);
        return answer;
    }
}