class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        play(k, dungeons, visited, 0);
        return answer;
    }
    private void play(int k, int[][] dungeons, boolean[] visited, int cnt){ // 피로도, 던전, 방문 유무
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            
            if(k >= dungeons[i][0]){
                int tmp = k - dungeons[i][1];
                visited[i] = true;
                cnt++;
                play(tmp, dungeons, visited, cnt);
                visited[i] = false;
                cnt--;
            }
        }
        answer = Math.max(cnt, answer);
    }
}