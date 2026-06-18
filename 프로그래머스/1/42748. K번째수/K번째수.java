import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            int[] command = commands[i];
            int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(arr);
            answer[i] = arr[command[2] - 1];
        }
        return answer;
    }
}