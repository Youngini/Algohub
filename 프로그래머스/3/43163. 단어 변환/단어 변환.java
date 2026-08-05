import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int[] step = new int[n];              // 0 = 미방문
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (diffIsOne(begin, words[i])) {
                step[i] = 1;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (words[cur].equals(target)) return step[cur];

            for (int i = 0; i < n; i++) {
                if (step[i] != 0) continue;
                if (!diffIsOne(words[cur], words[i])) continue;
                step[i] = step[cur] + 1;
                q.offer(i);
            }
        }
        return 0;
    }

    private boolean diffIsOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}