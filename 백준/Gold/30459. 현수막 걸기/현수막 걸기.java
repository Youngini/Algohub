import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] locations = new int[n];
        int[] heights = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < (int)n; i++){
            locations[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < (int)m; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(locations);
        Arrays.sort(heights);

        // 구현 시작
        double answer = -1.0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int d = locations[j] - locations[i];
                double maxH = (2.0 * r) / d;
                int idx = upperBound(heights, maxH) - 1;
                if (idx >= 0) {
                    double area = (heights[idx] * d) / 2.0;
                    answer = Math.max(answer, area);
                }
            }
        }

        if (answer < 0) System.out.println(-1);
        else System.out.printf("%.1f", answer);
    }
     private static int upperBound(int[] arr, double target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}