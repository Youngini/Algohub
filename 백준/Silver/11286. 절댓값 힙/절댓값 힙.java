import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int x;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) return o1 > o2 ? 1: -1;
            return first_abs - second_abs;
        });

        for(int i = 0; i < N; i++){
            x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty())System.out.println("0");
                else System.out.println(pq.poll());
            }else pq.add(x);
        }
    }
}