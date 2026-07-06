import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int m = Arrays.stream(arr).min().orElse(0);
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : arr){
            if(a == m) continue;
            list.add(a);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}