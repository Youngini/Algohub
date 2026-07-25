import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int max = 0;
        for(int s : stones) max = Math.max(max, s);
        int lo = 1;
        int hi = max;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int cnt = 0;
            int no = 0;
            for(int i = 0; i < stones.length; i++){
                if(stones[i] <= mid) cnt = Math.max(cnt, ++no);
                else no = 0;
            }
            if(cnt >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}