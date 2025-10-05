class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        if(slope(dots[0], dots[1]) == slope(dots[2], dots[3])) answer = 1;
        if(slope(dots[0], dots[2]) == slope(dots[1], dots[3])) answer = 1;
        if(slope(dots[0], dots[3]) == slope(dots[2], dots[1])) answer = 1;
        return answer;
    }
    
    public double slope(int[] a, int[] b){
        return (double)(b[1] - a[1]) / (b[0] - a[0]);
    }

}