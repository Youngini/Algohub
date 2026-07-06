class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = toBase3(n);
        int i = 1;
        for(char c : s.toCharArray()){
            answer += (c - '0') * i;
            i *= 3;
        }
        return answer;
    }
    private String toBase3(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % 3);
            n /= 3;
        }
        return sb.reverse().toString();
    } 
}