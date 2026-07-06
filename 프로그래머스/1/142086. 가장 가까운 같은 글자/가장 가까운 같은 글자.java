import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        int n = s.length();
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            int idx = c - 'a';
            answer[i] = (alphabet[idx] == -1) ? -1 : i + 1 - alphabet[idx];
            alphabet[idx] = i + 1;
        }
        return answer;
    }
}