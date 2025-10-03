class Solution {
    public int solution(int n, int k) {
        int q = n / 10;
        return n * 12000 + (k - q) * 2000;
    }
}