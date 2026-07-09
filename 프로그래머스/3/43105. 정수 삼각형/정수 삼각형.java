class Solution {
    public int solution(int[][] triangle) {
        int a = triangle.length;
        
        int[][] dp = new int[a][a];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < a; i++){
            for(int j = 0; j < i + 1; j++){
                if(j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if(j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        int answer = 0;
        for(int i : dp[a - 1]) answer = Math.max(answer, i);
        
        return answer;
    }
}