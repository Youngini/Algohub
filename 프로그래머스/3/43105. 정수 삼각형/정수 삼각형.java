class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                // 가장 왼쪽인 경우
                if(j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                // 가장 오른쪽인 경우
                else if(j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                // 나머지
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                
            }   
        }
        int answer = 0;
        for(int i : dp[n - 1]) answer = Math.max(answer, i);
        return answer;
    }
}