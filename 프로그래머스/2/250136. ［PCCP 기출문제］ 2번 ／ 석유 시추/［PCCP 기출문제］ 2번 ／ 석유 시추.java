import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int a = land.length;       // 세로
        int b = land[0].length;    // 가로
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean[][] visited = new boolean[a][b];
        int[] answer = new int[b]; // 각 열을 뚫었을 때 얻는 석유량

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int cnt = 0;
                    Set<Integer> cols = new HashSet<>(); // 이 덩어리가 걸친 열들

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;   // 넣을 때 바로 방문 표시

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0], y = cur[1];
                        cnt++;
                        cols.add(y);        // 이 칸이 속한 열 기록

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            // 범위 체크 먼저
                            if (nx < 0 || nx >= a || ny < 0 || ny >= b) continue;
                            if (land[nx][ny] == 1 && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                    // 덩어리가 걸친 모든 열에 cnt 더하기
                    for (int col : cols) {
                        answer[col] += cnt;
                    }
                }
            }
        }

        int ans = 0;
        for (int v : answer) ans = Math.max(ans, v);
        return ans;
    }
}