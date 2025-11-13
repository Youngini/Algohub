import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long val;
        int idx; // 입력에서의 인덱스 (0-based)
        Node(long v, int i) {
            val = v;
            idx = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            long v = Long.parseLong(st.nextToken());
            arr[i] = new Node(v, i);
        }

        // 값 기준 내림차순 정렬
        Arrays.sort(arr, (x, y) -> Long.compare(y.val, x.val));

        long[] prefix = new long[n];
        prefix[0] = arr[0].val;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i].val;
        }

        long a = arr[0].val;       // 항상 최댓값
        long ans = a + a + a;      // i = 0일 때 : {a}만 선택
        int bestR = 0;

        for (int i = 1; i < n; i++) {
            long b = arr[i].val;      // prefix 끝의 값 = prefix의 최솟값
            long c = prefix[i];       // prefix 합
            long score = a + b + c;   // min + max + sum = b + a + c
            if (score > ans) {
                ans = score;
                bestR = i;
            }
        }

        // 선택된 모듈 개수 = bestR + 1
        System.out.println(bestR + 1);

        // 그 모듈들의 원래 인덱스 (1-based로 출력한다고 가정)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= bestR; i++) {
            sb.append(arr[i].idx + 1).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
