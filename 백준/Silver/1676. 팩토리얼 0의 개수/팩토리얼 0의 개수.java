import java.io.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int tmp = i;
            while(tmp > 0){
                if(tmp % 5 == 0){
                    ans++;
                    tmp /= 5;
                }
                else break;
            }
        }
        System.out.println(ans);
    }
}
