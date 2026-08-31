import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        int i = 0;
        int h = 0;
        while(i < n){
            if(citations[i] < h){
                i++;
                continue;
            }
            if(n - i >= h){
                answer = Math.max(answer, h);
                h++;
            }
            else break;
        }
        return answer;
    }
}