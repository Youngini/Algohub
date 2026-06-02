class Solution {
    public String[] solution(String[] names) {
        int n = (names.length + 4) / 5;
        String[] answer = new String[n];
        int j = 0;
        for (int i = 0; i < names.length; i += 5) answer[j++] = names[i];
        return answer;
    }
}