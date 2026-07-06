class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){ 
                sb.append(' ');
                continue;
            }
            if(c - 'A'>= 0 && c - 'A' < 26){
                int tmp = (c - 'A' + n) % 26;
                sb.append((char)(tmp + 'A'));
            }
            else{
                int tmp = (c - 'a' + n) % 26;
                sb.append((char)(tmp + 'a'));
            }
        }
        return sb.toString();
    }
}