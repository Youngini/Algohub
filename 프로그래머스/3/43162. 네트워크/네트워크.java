class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){ 
                DFS(n, computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public void DFS(int n, int[][] computers, int node){
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && computers[node][i] == 1){
                visited[i] = true;
                DFS(n, computers, i);
            }
        } 
        return;
    }
}