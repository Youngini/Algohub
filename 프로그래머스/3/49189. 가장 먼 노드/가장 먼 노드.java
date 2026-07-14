import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        
        while(!deque.isEmpty()){
            int cur = deque.poll();
            for(int i : graph.get(cur)){
                if(dist[i] == -1){
                    dist[i] = dist[cur] + 1;
                    deque.offer(i);
                }
            }
        }
        
        int M = -1;
        for(int i : dist) M = Math.max(i, M);
        int answer = 0;
        for(int i : dist) if(i == M) answer++;
        return answer;
        
    }
}