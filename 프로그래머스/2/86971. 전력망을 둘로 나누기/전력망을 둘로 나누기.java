import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        // 1. 인접 리스트에 기록하기
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] w : wires){ 
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        int answer = n;
        
        // 2. 하나씩 끊으면서 확인
        for(int[] w : wires){
            // 3. 한 그룹의 크기를 확인
            int cnt = BFS(graph, 1, w[0], w[1]);
            
            // 4. 차이 구하기
            int diff = Math.abs(2 * cnt - n);
            
            // 5. answer 최소값 구하기
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    private int BFS(ArrayList<ArrayList<Integer>> graph, int start, int w1, int w2){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            
            for(int next : graph.get(cur)){
                if((cur == w1 && next == w2) || (cur == w2 && next == w1)) continue;
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            } 
        }
        return count;
    }

}