import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int n = numbers.length;
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) arr[i] = numbers[i] + "";
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        for(String s : arr) sb.append(s);
        return sb.toString();
    }
}