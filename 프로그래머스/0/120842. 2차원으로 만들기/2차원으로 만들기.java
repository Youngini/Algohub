class Solution {
    public int[][] solution(int[] num_list, int n) {
        int m = num_list.length / n;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(num_list, i * n, answer[i], 0, n);
        }
        return answer;
    }
}
