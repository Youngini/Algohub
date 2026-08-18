import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int answer = 0;
        int end = -30001;
        for(int[] route : routes){
            if(end < route[0]){
                end = route[1];
                answer++;
            }
        }
        return answer;
    }
}