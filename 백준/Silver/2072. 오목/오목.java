import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int[][] baduk = new int[20][20];
        int x, y, nx, ny, cnt;
        int ans = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 바둑 두기 흑 1, 백 -1
        for(int i = 0; i < n; i++){
            x = arr[i][0];
            y = arr[i][1];

            if(i % 2 == 0){
                baduk[x][y] = 1;
            }
            else{
                baduk[x][y] = -1;
            }

            // 가로
            cnt = 1;
            nx = x - 1;
            while(nx > 0){
                if(baduk[nx][y] == baduk[x][y]){
                    cnt++;
                    nx--;
                }
                else break;
            }

            nx = x + 1;
            while(nx < 20){
                if(baduk[nx][y] == baduk[x][y]){
                    cnt++;
                    nx++;
                }
                else break;
            }

            if(cnt == 5){
                ans = i + 1;
                break;
            }


            // 세로
            cnt = 1;
            ny = y - 1;
            while(ny > 0){
                if(baduk[x][ny] == baduk[x][y]){
                    cnt++;
                    ny--;
                }
                else break;
            }

            ny = y + 1;
            while(ny < 20){
                if(baduk[x][ny] == baduk[x][y]){
                    cnt++;
                    ny++;
                }
                else break;
            }

            if(cnt == 5){
                ans = i + 1;
                break;
            }

            // 대각선 - 기울기 양수
            cnt = 1;
            nx = x - 1;
            ny = y - 1;

            while(nx > 0 && ny > 0){
                if(baduk[nx][ny] == baduk[x][y]){
                    cnt++;
                    nx--;
                    ny--;
                }
                else break;
            }

            nx = x + 1;
            ny = y + 1;

            while(nx < 20 && ny < 20){
                if(baduk[nx][ny] == baduk[x][y]){
                    cnt++;
                    nx++;
                    ny++;
                }
                else break;
            }

            if(cnt == 5){
                ans = i + 1;
                break;
            }

            // 대각선 - 기울기 음수

            cnt = 1;
            nx = x - 1;
            ny = y + 1;

            while(nx > 0 && ny < 20){
                if(baduk[nx][ny] == baduk[x][y]){
                    cnt++;
                    nx--;
                    ny++;
                }
                else break;
            }

            nx = x + 1;
            ny = y - 1;

            while(nx < 20 && ny > 0){
                if(baduk[nx][ny] == baduk[x][y]){
                    cnt++;
                    nx++;
                    ny--;
                }
                else break;
            }

            if(cnt == 5){
                ans = i + 1;
                break;
            }
        }

        System.out.println(ans);

    }
}