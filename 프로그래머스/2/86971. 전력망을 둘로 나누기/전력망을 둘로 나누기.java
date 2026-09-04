import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            List<List<Integer>> graph = new ArrayList<>();
            for(int j = 0; j <= n; j++) graph.add(new ArrayList<>());
            for(int j = 0; j < n - 1; j++){
                if(i == j) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(1);
            visited[1] = true;
            int cnt = 1;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : graph.get(cur)){
                    if(visited[next]) continue;
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
            
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
            
        }
        return answer;
    }
}