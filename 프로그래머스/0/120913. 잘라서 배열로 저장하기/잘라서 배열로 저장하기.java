class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int size = (len + n - 1) / n;
        String[] answer = new String[size];
        for (int i = 0, idx = 0; i < len; i += n, idx++) {
            answer[idx] = my_str.substring(i, Math.min(i + n, len));
        }
        return answer;
    }
}