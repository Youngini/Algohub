class Solution {
    public int solution(String myString, String pat) {
        int n = pat.length();
        int answer = 0;
        if(myString.length() < pat.length()) return 0;
        else if(myString.length() == pat.length()) return (myString.equals(pat)) ? 1 : 0;
        else{
            for(int i = 0; i < myString.length() - n + 1; i++){
                if(myString.substring(i, i + n).equals(pat)) answer++;
            }
        }
        
        return answer;
    }
}