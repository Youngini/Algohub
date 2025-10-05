class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        for(int i = 1; i < array.length; i++){
            if(Math.abs(answer - n) > Math.abs(array[i] - n)) answer = array[i];
            if(Math.abs(answer - n) == Math.abs(array[i] - n)) answer = answer - array[i] > 0 ? array[i] : answer;
        }
        return answer;
    }
}