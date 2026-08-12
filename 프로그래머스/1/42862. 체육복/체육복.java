import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] spare = new boolean[n + 2];
        boolean[] isLost = new boolean[n + 2];

        for (int r : reserve) spare[r] = true;
        for (int l : lost) isLost[l] = true;

        // 여벌이 있는데 도난당한 학생은 자기 것을 입는다
        for (int i = 1; i <= n; i++) {
            if (spare[i] && isLost[i]) {
                spare[i] = false;
                isLost[i] = false;
            }
        }

        int answer = n;
        for (int i = 1; i <= n; i++) {
            if (!isLost[i]) continue;
            if (i - 1 >= 1 && spare[i - 1]) spare[i - 1] = false;
            else if (i + 1 <= n && spare[i + 1]) spare[i + 1] = false;
            else answer--;
        }
        return answer;
    }
}