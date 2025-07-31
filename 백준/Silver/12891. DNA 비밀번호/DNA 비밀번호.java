import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ACGT[];
    static int State[];
    static int check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0; // 정답
        ACGT = new int[4];
        State = new int[4];
        char DNA[] = new char[S];
        check = 0;
    
        DNA = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            ACGT[i] = Integer.parseInt(st.nextToken());
            if(ACGT[i] == 0) check += 1;
        }

        // 부분문자열 처음 받을 때
        for(int i = 0; i < P; i++){
            Add(DNA[i]);    
        }

        if(check == 4) result++;

        // 슬라이딩 윈도우
        for(int i = P; i < S; i++){
            int j = i - P;
            Add(DNA[i]);
            Sub(DNA[j]);
            if(check == 4) result++;
        }
        System.out.println(result);
        br.close();
    }

    private static void Sub(char c) {
        switch (c) {
            case 'A':
                if(State[0] == ACGT[0]) check--;
                State[0]--;
                break;
            case 'C':
                if(State[1] == ACGT[1]) check--;
                State[1]--;
                break;
            case 'G':
                if(State[2] == ACGT[2]) check--;    
                State[2]--;
                break;
            case 'T':
                if(State[3] == ACGT[3]) check--;
                State[3]--;
                break;
                
        }    
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                State[0]++;
                if(State[0] == ACGT[0]) check++;
                break;
            case 'C':
                State[1]++;
                if(State[1] == ACGT[1]) check++;
                break;
            case 'G':
                State[2]++;
                if(State[2] == ACGT[2]) check++;
                break;
            case 'T':
                State[3]++;
                if(State[3] == ACGT[3]) check++;
                break;
        }    
    }
    
}
