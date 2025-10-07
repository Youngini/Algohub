import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxCnt = 0, mode = -1;
        boolean tie = false;

        for (int x : array) {
            int c = freq.getOrDefault(x, 0) + 1;
            freq.put(x, c);
            if (c > maxCnt) {        // 새 최대 빈도 등장
                maxCnt = c;
                mode = x;
                tie = false;         // 현재는 단독 1위
            } else if (c == maxCnt && x != mode) {
                tie = true;          // 다른 값이 같은 최대 빈도에 도달 → 동점
            }
        }
        return tie ? -1 : mode;
    }
}