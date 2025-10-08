class Solution {
    public int[] solution(int[] num_list, int n) {
        int k = (num_list.length - 1) / n + 1;
        int[] answer = new int[k];
        for(int i = 0; i < k; i++) answer[i] = num_list[n * i];
        return answer;
    }
}