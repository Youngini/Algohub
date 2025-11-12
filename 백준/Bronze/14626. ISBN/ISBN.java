import java.io.*;
import java.util.*;

public class Main {
    static int N = 13;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ISBN = br.readLine().strip();
        int answer = 0;
        int index = 12; // *의 자리
        int tmp = 0; 

        for(int i = 0; i < N - 1; i++){
            char c = ISBN.charAt(i);
            if(c == '*'){
                index = i;
                continue;
            }
            int a = c - '0';
            if(i % 2 == 0) tmp += a;
            else tmp += a * 3;
        }

        if(index == 12) answer = (10 - (tmp % 10)) % 10;
        else if(index % 2 == 0){
            for(int i = 0; i < 10; i++){
                int m = (ISBN.charAt(12) - '0');
                int t = tmp + i;
                if(m == (10 - t % 10) % 10){
                    answer = i;
                    break;
                }
            }
        }
        else{
            for(int i = 0; i < 10; i++){
                int m = (ISBN.charAt(12) - '0');
                int t = tmp + i * 3;
                if(m == (10 - t % 10) % 10){
                    answer = i;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
