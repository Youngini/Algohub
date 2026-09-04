class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            int p = prices[i];
            for(int j = i + 1; j < n; j++){
                answer[i]++;
                if(p > prices[j]) break;
            }
        }
        
        return answer;
    }
}