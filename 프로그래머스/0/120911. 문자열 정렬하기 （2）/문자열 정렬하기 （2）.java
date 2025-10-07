import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toLowerCase().toCharArray(); // 모두 소문자
        Arrays.sort(arr);                                   // 알파벳 순 정렬
        return new String(arr);
    }
}
