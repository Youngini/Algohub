class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int index = 0;
        for(int[] q : queries){
            int s = q[0];
            int e = q[1];
            int k = q[2];
            int tmp = 1000001;
            for(int i = s; i <= e; i++){
                if((k < arr[i]) && (arr[i] < tmp)) tmp = arr[i]; 
            }
            if(tmp == 1000001) tmp = -1;
            answer[index++] = tmp;
        }
        return answer;
    }
}