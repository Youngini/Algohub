class Solution {
    public int solution(String number) {
        int tmp = 0;
        for(char c : number.toCharArray()){
            tmp += c - '0';
        }
        return tmp %= 9;
    }
}