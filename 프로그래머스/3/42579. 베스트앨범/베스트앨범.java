import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        int n = genres.length;
        for(int i = 0; i < n; i++){
            String key = genres[i];
            map.put(key, map.getOrDefault(key, 0) + plays[i]);
        }
        int[][] music = new int[n][3];
        for(int i = 0; i < n; i++){
            String key = genres[i];
            music[i][0] = map.get(key);
            music[i][1] = plays[i];
            music[i][2] = i;
        }
        Arrays.sort(music, (a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            else if(a[1] != b[1]) return b[1] - a[1];
            return a[2] - b[2];
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for(int[] m : music){
            String k = genres[m[2]];
            count.put(k, count.getOrDefault(k, 0) + 1);
            
            if(count.get(k) > 2) continue;
            else answer.add(m[2]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}