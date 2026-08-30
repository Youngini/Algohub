import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] c : commands){
            int[] tmp = Arrays.copyOfRange(array, c[0] - 1, c[1]);
            Arrays.sort(tmp);
            answer.add(tmp[c[2] - 1]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}