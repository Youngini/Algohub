import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for(int v : map.values()){
            answer *= (v + 1);
        }
        return answer - 1;
    }
}