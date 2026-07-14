import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] e : results) graph.get(e[0]).add(e[1]);
    
        Set<Integer>[] winners = new HashSet[n + 1];
        Set<Integer>[] losers = new HashSet[n + 1];
        
        for (int i = 0; i <= n; i++) {
            winners[i] = new HashSet<>();
            losers[i] = new HashSet<>();
        }
        
        for(int i = 1; i <= n; i++){
            boolean[] isVisited = new boolean[n + 1];
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            isVisited[i] = true;
            
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next : graph.get(cur)){
                    if(!isVisited[next]){
                        winners[i].add(next);
                        losers[next].add(i);
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int tmp = winners[i].size() + losers[i].size();
            if(tmp == n - 1) answer++;
        }
        return answer;
    }
}