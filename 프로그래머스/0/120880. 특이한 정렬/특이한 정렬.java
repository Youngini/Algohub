import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int len = numlist.length;
        int[][] temp = new int[len][2]; // [0]=거리, [1]=값

        for (int i = 0; i < len; i++) {
            temp[i][0] = Math.abs(numlist[i] - n);
            temp[i][1] = numlist[i];
        }

        Arrays.sort(temp, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // 거리 오름차순
            return Integer.compare(b[1], a[1]);                   // 값 내림차순(큰 수 우선)
        });

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = temp[i][1];
        }
        return answer;
    }
}
