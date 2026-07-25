import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] inTime = new int[10000];
        int[] totals = new int[10000];
        boolean[] parking = new boolean[10000];
        TreeSet<Integer> cars = new TreeSet<>();      // 정렬 자동 해결

        for (String r : records) {
            String[] tmp = r.split(" ");
            String[] hm = tmp[0].split(":");
            int cur = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            int idx = Integer.parseInt(tmp[1]);
            cars.add(idx);

            if (tmp[2].equals("IN")) {
                inTime[idx] = cur;
                parking[idx] = true;
            } else {
                totals[idx] += cur - inTime[idx];      // += 누적
                parking[idx] = false;
            }
        }

        int[] answer = new int[cars.size()];
        int i = 0;
        for (int c : cars) {                            // 오름차순 순회
            int t = totals[c];
            if (parking[c]) t += 1439 - inTime[c];      // 미출차 → 23:59

            if (t <= fees[0]) answer[i++] = fees[1];
            else answer[i++] = fees[1] + ((t - fees[0] - 1) / fees[2] + 1) * fees[3];
        }
        return answer;
    }
}