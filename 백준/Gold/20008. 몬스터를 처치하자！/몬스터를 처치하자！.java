import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int HP;
    static int[] C;
    static int[] D;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int time, int hp, int[] cd) {
        // 몬스터가 죽으면 종료
        if (hp <= 0) {
            answer = Math.min(answer, time);
            return;
        }

        // 이미 최적해보다 느리면 가지치기
        if (time >= answer) return;

        boolean used = false;

        // 모든 스킬 시도
        for (int i = 0; i < N; i++) {

            if (cd[i] == 0) { // 쓸 수 있는 스킬
                used = true;

                int[] newCd = cd.clone();
                int newHp = hp - D[i];

                newCd[i] = C[i]; // 스킬 쿨타임 초기화

                // 1초 흐름 → 쿨타임 감소
                for (int j = 0; j < N; j++) {
                    if (newCd[j] > 0) newCd[j]--;
                }

                dfs(time + 1, newHp, newCd);
            }
        }

        // 스킬을 하나도 못 쓰면 기다리기
        if (!used) {
            int[] newCd = cd.clone();
            for (int j = 0; j < N; j++) {
                if (newCd[j] > 0) newCd[j]--;
            }
            dfs(time + 1, hp, newCd);
        }
    }
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        HP = Integer.parseInt(st.nextToken());

        C = new int[N];
        D = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, HP, new int[N]);

        System.out.println(answer);
    }
}
