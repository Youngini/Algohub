class Solution {
    public int[] solution(int n) {
        int index = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] answer = new int[index];
        for(int i = 0; i < index ; i++ ) answer[i] = (2 * i + 1);
        return answer;
    }
}