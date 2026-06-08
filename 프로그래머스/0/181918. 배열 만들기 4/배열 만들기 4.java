import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            if(stk.isEmpty()) stk.add(arr[i++]);
            else{
                int n = stk.size() - 1;
                if(stk.get(n) < arr[i]){ 
                    stk.add(arr[i++]);
                }
                else stk.remove(n);
            }
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}