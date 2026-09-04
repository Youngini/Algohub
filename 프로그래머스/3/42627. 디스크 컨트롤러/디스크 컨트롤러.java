import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length, idx = 0, t = 0, done = 0;
        long total = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while(done < n){
            while(idx < n && jobs[idx][0] <= t) pq.offer(jobs[idx++]);
            
            if(pq.isEmpty()){
                t = jobs[idx][0];
                continue;
            }
            
            int[] cur = pq.poll();
            t += cur[1];
            total += (t - cur[0]);
            done ++;
        }
        return (int)(total / n);
    }
}