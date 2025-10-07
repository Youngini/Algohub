import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        int m = score.length;
        int[][] arr = new int[m][2]; // [총점, 원래 인덱스]
        for (int i = 0; i < m; i++) {
            arr[i][0] = score[i][0] + score[i][1];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0])); // 총점 내림차순

        int[] answer = new int[m];
        int rank = 1;
        for (int i = 0; i < m; i++) {
            if (i > 0 && arr[i][0] != arr[i - 1][0]) {
                rank = i + 1; // 새 점수면 현재 위치 기준 등수
            }
            answer[arr[i][1]] = rank; // 원래 인덱스 자리에 등수 기록
        }
        return answer;
    }
}
