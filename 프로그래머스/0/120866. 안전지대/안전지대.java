class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] unsafe = new boolean[n][n];

        int[] dx = {-1,-1,-1, 0,0, 1,1,1};
        int[] dy = {-1, 0, 1,-1,1,-1,0,1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    unsafe[i][j] = true; // 지뢰 위치
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                            unsafe[ni][nj] = true;
                        }
                    }
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!unsafe[i][j]) safe++;
            }
        }
        return safe;
    }
}
