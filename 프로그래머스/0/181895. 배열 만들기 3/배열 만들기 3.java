class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int n = 0;
        for(int[] tmp : intervals) n += tmp[1] - tmp[0] + 1;

        int[] answer = new int[n];
        int j = 0;
        for(int[] tmp : intervals){
            for(int i = tmp[0]; i <= tmp[1]; i++) answer[j++] = arr[i];
        }
        
        return answer;
    }
}