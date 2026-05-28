class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = (arr1.length > arr2.length) ? 1 : (arr1.length < arr2.length) ? -1 : 0;
        if(answer == 0){
            int n1 = 0;
            int n2 = 0;
            for(int n : arr1) n1 += n;
            for(int n : arr2) n2 += n;
            answer = (n1 > n2) ? 1 : (n1 < n2) ? -1 : 0;
        }
        return answer;
    }
}