class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int a = sides[0] > sides[1] ? sides[0] : sides[1];
        int b = sides[0] > sides[1] ? sides[1] : sides[0];
        
        // 나머지 하나가 가장 긴 변인 경우
        int c = a;
        while(c < a + b){
            answer++;
            c += 1;
        }
        // a가 가장 긴 변인 경우
        c = a - b + 1;
        while(c < a){
            answer++;
            c++;
        }
        
        return answer;
    }
}