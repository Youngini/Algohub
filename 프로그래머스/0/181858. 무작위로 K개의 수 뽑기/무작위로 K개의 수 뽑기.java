import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> seen = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int x : arr){
            if (list.size() == k) break; 
            if(!seen.contains(x)){
                seen.add(x);
                list.add(x);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = (i < list.size()) ? list.get(i) : -1;
        }
        return ans;
        
    }
}