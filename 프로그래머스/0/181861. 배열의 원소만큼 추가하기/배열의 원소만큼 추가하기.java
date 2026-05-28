import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int n = Arrays.stream(arr).sum();
        int[] ans = new int[n];
        int k = 0;
        for(int i : arr){
            for(int j = 0; j < i; j++){
                ans[k++] = i;
            }
        }
        return ans;
    }
}