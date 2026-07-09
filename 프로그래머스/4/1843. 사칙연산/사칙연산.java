import java.util.*;

class Solution {
    public int solution(String[] arr) {
        // 숫자와 연산자 분리
        int n = (arr.length + 1) / 2;
        int[] nums = new int[n];
        char[] ops = new char[n - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]);
            else ops[i / 2] = arr[i].charAt(0);
        }
        
        // DP 배열
        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }
        
        // 길이 늘려가며 채우기
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                // 모든 자르는 지점 k
                for (int k = i; k < j; k++) {
                    if (ops[k] == '+') {
                        max = Math.max(max, dpMax[i][k] + dpMax[k+1][j]);
                        min = Math.min(min, dpMin[i][k] + dpMin[k+1][j]);
                    } else {
                        max = Math.max(max, dpMax[i][k] - dpMin[k+1][j]);
                        min = Math.min(min, dpMin[i][k] - dpMax[k+1][j]);
                    }
                }
                dpMax[i][j] = max;
                dpMin[i][j] = min;
            }
        }
        
        return dpMax[0][n - 1];
    }
}