import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.offer(s);
        
        while(true){
            if(pq.peek() >= K || pq.size() < 2) break;
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            int s3 = s1 + s2 * 2;
            pq.offer(s3);
            answer++;
        }
        
        return (pq.poll() >= K) ? answer : -1;
    }
}