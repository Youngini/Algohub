import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] scores = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            int s = Integer.parseInt(st.nextToken());
            scores[s] = i;
        }

        // 풀이 시작
        for(int i = 1; i < n + 1; i++){
           System.out.println(i- scores[i]);
        }
    }
}
