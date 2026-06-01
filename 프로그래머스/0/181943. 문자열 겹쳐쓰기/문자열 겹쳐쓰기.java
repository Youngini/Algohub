class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int n = my_string.length();
        int i = 0;
        while(i < n){
            if(i == s){ 
                i = s + overwrite_string.length();
                answer += overwrite_string;
            }
            else{
                answer += my_string.charAt(i);
                i++;
            }
            
        }
        return answer;
    }
}