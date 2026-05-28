class Solution {
    public int[] solution(int[] arr, int n) {
        int index = arr.length;
        // 홀수라면
        if(index % 2 != 0){
            for(int i = 0; i < index; i += 2){
                arr[i] += n;
            }
        }
        // 짝수라면
        else{
            for(int i = 1; i < index; i += 2){
                arr[i] += n;
            }
        }
        return arr;
    }
}