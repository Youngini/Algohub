class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lo = 1, hi = 100000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canSolve(diffs, times, limit, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                long prev = (i > 0) ? times[i - 1] : 0;
                total += (long)(times[i] + prev) * (diffs[i] - level) + times[i];
            }
            if (total > limit) return false;
        }
        return true;
    }
}