import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answer = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == A[i % 5]) answer[0]++;
            if(answers[i] == B[i % 8]) answer[1]++;
            if(answers[i] == C[i % 10]) answer[2]++;
        }
        
        int M = -1;
        for(int a : answer){
            M = Math.max(M, a);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) if(answer[i] == M) arr.add(i + 1);
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}