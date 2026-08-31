import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String key : completion) map.put(key, map.getOrDefault(key, 0) + 1);
        for(String key : participant){
            map.put(key, map.getOrDefault(key, 0) - 1);
            if(map.get(key) < 0) return key;
        }
        return "";
    }
}