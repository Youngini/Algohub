class Solution {
    public boolean solution(int x) {
        int p = x;
        int q = 0;
        while(x > 0){
            q += x % 10;
            x /= 10;
        }
        if(p % q == 0) return true;
        else return false;
    }
}