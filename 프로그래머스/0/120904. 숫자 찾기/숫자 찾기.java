class Solution {
    public int solution(int num, int k) {
        int l = 0;
        int find = 0;
        while(num > 0){
            l++;
            if((num % 10) == k) find = l;
            num /= 10;
        }
        if(find == 0) return -1;
        else return l - find + 1;
        
    }
}