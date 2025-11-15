import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i ++){
            double k = Double.parseDouble(br.readLine());
            int idx = upperBound(x, k);     // x[idx] > k

            int i1 = idx - 1;  // x[i1] < k < x[idx]
            int i2 = idx;

            sb.append(findM(x[i2], y[i2], x[i1], y[i1])).append("\n");
        }

        System.out.print(sb);
    }

    static int upperBound(int[] x, double k){
        int left = 0, right = x.length;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(x[mid] > k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static int findM(int x2, int y2, int x1, int y1){
        long dy = y2 - y1;
        if(dy > 0) return 1;
        else if(dy < 0) return -1;
        else return 0;
    }
}
