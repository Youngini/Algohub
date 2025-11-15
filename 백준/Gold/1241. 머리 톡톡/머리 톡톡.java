import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (a[i] > max) max = a[i];
        }

        int[] freq = new int[max + 1];
        for (int v : a) freq[v]++;

        int[] ansVal = new int[max + 1];

        // 배수에 freq 뿌리기
        for (int d = 1; d <= max; d++) {
            if (freq[d] == 0) continue;
            for (int m = d; m <= max; m += d) {
                ansVal[m] += freq[d];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ansVal[a[i]] - 1).append('\n');
        }
        System.out.print(sb);
    }
}
