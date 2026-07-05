class Solution {
    public int solution(String s) {
        if(s.charAt(0) == '+') return Integer.parseInt(s.substring(1, s.length()));
        else if(s.charAt(0) == '-') return Integer.parseInt(s.substring(1, s.length())) * -1;
        else return Integer.parseInt(s);
    }
}