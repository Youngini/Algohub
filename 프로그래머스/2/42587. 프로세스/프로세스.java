import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[]{priorities[i], i});
        }
        
        Arrays.sort(priorities);
        int i = priorities.length - 1;
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == priorities[i]){
                if(tmp[1] == location) return cnt;
                cnt++;
                i--;
            }
            else queue.offer(tmp);
        }
        return 0;
    }
}