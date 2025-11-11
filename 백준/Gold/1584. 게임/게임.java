import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 501;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map = new int[SIZE][SIZE];
    static int[][] dist = new int[SIZE][SIZE];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1️⃣ 위험 구역 입력
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fillArea(x1, y1, x2, y2, 1); // 위험 지역 = 1
        }

        // 2️⃣ 죽음 구역 입력
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fillArea(x1, y1, x2, y2, -1); // 죽음 지역 = -1
        }

        // 3️⃣ 거리 초기화
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(dist[i], INF);
        }

        // 4️⃣ BFS 수행
        int answer = bfs();

        System.out.println(answer);
    }

    static void fillArea(int x1, int y1, int x2, int y2, int value) {
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                // 죽음 지역이 최우선
                if (value == -1) map[i][j] = -1;
                else if (map[i][j] != -1) map[i][j] = 1;
            }
        }
    }

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            // 도착
            if (x == 500 && y == 500) return dist[x][y];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx > 500 || ny > 500) continue;
                if (map[nx][ny] == -1) continue; // 죽음 지역은 통과 불가

                int cost = (map[nx][ny] == 1) ? 1 : 0;

                if (dist[nx][ny] > dist[x][y] + cost) {
                    dist[nx][ny] = dist[x][y] + cost;
                    if (cost == 1) dq.addLast(new int[]{nx, ny});
                    else dq.addFirst(new int[]{nx, ny});
                }
            }
        }

        return -1; // 도착 불가
    }
}
