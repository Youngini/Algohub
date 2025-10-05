class Solution {
    public int solution(int a, int b) {
        int i = 2;
        while( (i <= a) && (i <= b)){
            if((a % i == 0) && (b % i == 0)){
                a /= i;
                b /= i;
            }
            else i++;
        }
        
        while(b % 2 == 0){
            b /= 2;
        }
        while(b % 5 == 0){
            b /= 5;
        }
        if (b == 1) return 1;
        else return 2;
    
    }
}