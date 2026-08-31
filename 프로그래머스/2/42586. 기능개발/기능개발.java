import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int n = progresses.length;
        ArrayList<Integer> times = new ArrayList<>();
        for(int i = 0; i < n; i++){
            times.add((100 - progresses[i] + speeds[i] - 1) / speeds[i]);
        }
        
        while(!times.isEmpty()){
            int cnt = 0;
            int s = times.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < s; i++){
                if(times.get(i) <= times.get(0)) cnt++;
                else{
                    for(int j = i; j < s; j++) arr.add(times.get(j));
                    break;
                }
            }
            answer.add(cnt);
            times = arr;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}