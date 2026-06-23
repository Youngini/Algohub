import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int[][] arr = new int[sizes.length][2];
        for(int i = 0; i < sizes.length; i++){
            arr[i][0] = Math.max(sizes[i][0], sizes[i][1]);
            arr[i][1] = Math.min(sizes[i][0], sizes[i][1]);
        }
        int w = 0;
        int h = 0;
        for(int i = 0; i < sizes.length; i++){
            w = Math.max(arr[i][0], w);
            h = Math.max(arr[i][1], h);
        }
        return w * h;
    }
}