class Solution {
    public int solution(int n) {
        int answer = 0;
        int factorial = 1;
        int i = 1;
        while(factorial <= n){
            i += 1;
            answer += 1;
            factorial *= i;
        }
        return answer;
    }
}