class Solution {
    public int solution(String binomial) {
        String[] tmp = binomial.split(" ");
        if (tmp[1].equals("+")) return Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]);
        else if (tmp[1].equals("-")) return Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]);
        else return Integer.parseInt(tmp[0]) * Integer.parseInt(tmp[2]);
    }
}