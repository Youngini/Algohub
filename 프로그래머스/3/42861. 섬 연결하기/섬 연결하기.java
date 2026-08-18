import java.util.*;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;  // 처음엔 각자가 대표

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int answer = 0, cnt = 0;
        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) {   // 다른 그룹이면 합치고 true
                answer += cost[2];
                if (++cnt == n - 1) break;
            }
        }
        return answer;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);  // 경로 압축
    }

    static boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;  // 이미 같은 그룹 = 사이클
        parent[rb] = ra;
        return true;
    }
}