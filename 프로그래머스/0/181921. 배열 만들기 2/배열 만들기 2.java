import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int bit = 0; bit < 128; bit++){
            int n = Integer.parseInt(Integer.toBinaryString(bit)) * 5;
            if(n >= l && n <= r) answer.add(n);
        }
        
        if(answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}