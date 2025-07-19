import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int score[] = new int[N];
        for(int i = 0; i < N; i++) score[i] = sc.nextInt();

        int max = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            if(max < score[i]) max = score[i];
            sum += score[i];
        }
        System.out.print(sum * 100.0 / max / N);
    }
    
}
