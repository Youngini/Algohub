class Solution {
    public int solution(int balls, int share) {
        int k = Math.min(share, balls - share); // 대칭성으로 반복 줄이기
        double ans = 1.0;
        for (int i = 1; i <= k; i++) {
            ans *= (double)(balls - k + i) / i;
        }
        return (int) Math.round(ans);
    }
}

