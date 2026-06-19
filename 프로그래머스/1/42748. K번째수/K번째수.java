import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int[] c : commands) {
            int s = c[0] - 1;
            int e = c[1];
            int k = c[2] - 1;
            
            int[] sliced = Arrays.copyOfRange(array, s, e);
            Arrays.sort(sliced);
            answer.add(sliced[k]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}