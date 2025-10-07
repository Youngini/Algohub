class Solution {
    public String solution(String my_string) {
        String answer = "";
        boolean[] check = new boolean[128];
        for(char c : my_string.toCharArray()){
            if(!check[c]){
                check[c] = true;
                answer += c;
            }
        }
        return answer;
    }
}