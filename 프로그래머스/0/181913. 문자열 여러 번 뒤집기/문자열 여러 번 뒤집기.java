class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int[] q : queries){
            int s = q[0]; 
            int l = q[1];
            String reversed = new StringBuilder(my_string.substring(s, l + 1))
                .reverse()
                .toString();
             my_string = my_string.substring(0, s) + reversed + my_string.substring(l + 1);
        }
        return my_string;
    }
}