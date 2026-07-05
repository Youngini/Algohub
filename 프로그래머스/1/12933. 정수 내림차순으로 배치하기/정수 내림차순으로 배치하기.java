import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        Collections.sort(arr, Collections.reverseOrder());
        for (long l : arr) answer = answer * 10 + l;
        return answer;
    }
}