class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int cnt = 1;
        int x = 0;
        int y = 0;
        int i = 0;
        
        while(cnt <= n * n){
            answer[x][y] = cnt++;
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0){
                i = (i + 1) % 4;
                 nx = x + dx[i];
                ny = y + dy[i];
            }
            
            x = x + dx[i];
            y = y + dy[i];
        }
        
        return answer;
    }
}