import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] maps = new int[102][102];
        boolean[][] visited = new boolean[102][102];
        
        // 직사각형 지나는 위치 모두 표시
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2, y1 = rec[1] * 2, x2 = rec[2] * 2, y2 = rec[3] * 2;
            for(int i = x1; i <= x2; i++){
                maps[i][y1] = 1;
                maps[i][y2] = 1;
            }
            for(int i = y1; i <= y2; i++){
                maps[x1][i] = 1;
                maps[x2][i] = 1;
            }
        }
        
        // 직사각형이 겹치는 부분 제외
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2, y1 = rec[1] * 2, x2 = rec[2] * 2, y2 = rec[3] * 2;
            for(int x = x1 + 1; x < x2; x++){
                for(int y = y1 + 1; y < y2; y++) maps[x][y] = 0;
            }
        }
        
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {characterX * 2, characterY * 2, 1});
        visited[characterX * 2][characterY * 2] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == itemX * 2 && cur[1] == itemY * 2) return cur[2] / 2;
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                if(visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                q.offer(new int[] {nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
                
            }
        }
        
        return answer;
    }
}