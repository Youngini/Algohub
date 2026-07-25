import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuffer sb = new StringBuffer();
        int[] prev = new int[n]; // 이전 인덱스
        int[] next = new int[n]; // 다음 인덱스
        for (int i = 0; i < n; i++) { prev[i] = i - 1; next[i] = i + 1; }
        boolean[] isDeleted = new boolean[n]; // 삭제 유무
        Deque<Integer> stack = new ArrayDeque<>(); // 삭제된 값들을 저장
        int cur = k; // 현재 위치
        
        for(String c : cmd){
            char op = c.charAt(0);
            
            if(op == 'U'){
                String[] tmp = c.split(" ");
                int x = Integer.parseInt(tmp[1]); 
                for(int i = 0; i < x; i++){
                    cur = prev[cur];
                }
            }
            else if(op == 'D'){
                String[] tmp = c.split(" ");
                int x = Integer.parseInt(tmp[1]); 
                for(int i = 0; i < x; i++){
                    cur = next[cur];
                }
            }
            else if(op == 'C'){
                stack.offerLast(cur);
                isDeleted[cur] = true;
                if(prev[cur] == -1){
                    prev[next[cur]] = prev[cur];
                    cur = next[cur];
                }
                else if(next[cur] == n){ // 현재 위치가 마지막 줄
                    next[prev[cur]] = next[cur];
                    cur = prev[cur];
                }
                else{
                    next[prev[cur]] = next[cur];
                    prev[next[cur]] = prev[cur];
                    cur = next[cur];
                }
            }
            else{
                int t = stack.pollLast();
                isDeleted[t] = false;
                if(prev[t] == -1){
                    prev[next[t]] = t;
                }
                else if(next[t] == n){
                    next[prev[t]] = t;
                }
                else{
                    next[prev[t]] = t;
                    prev[next[t]] = t;
                }
            }
        }
        for(boolean b : isDeleted){
            if(b) sb.append("X");
            else sb.append("O");
        }
        
        return sb.toString();
    }
}