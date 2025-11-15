import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        
        int round = 0;
        while (K != I) {
            K = (K + 1) / 2;
            I = (I + 1) / 2;
            round++;
        }
        
        System.out.println(round);
    }
}
