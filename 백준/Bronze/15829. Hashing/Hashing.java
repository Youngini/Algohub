import java.io.*;

public class Main {
    static int r = 31;
    static int M = 1234567891;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine().strip();

        long hash = 0;
        long pow = 1;

        for(int i = 0; i < n; i++){
            int a = s.charAt(i) - 'a' + 1;
            hash = (hash + a * pow) % M;
            pow = (pow * r) % M;
        }
        System.out.println(hash);
    }
}
