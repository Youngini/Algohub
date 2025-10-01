class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int mul = 1;
        int square = 0;
        for(int i = 0; i < num_list.length; i++){
            mul *= num_list[i];
            square += num_list[i];
        }
        square = square * square;
        if(mul < square){
            answer = 1;
        }
        return answer;
    }
}