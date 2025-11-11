import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String DNA1 = br.readLine();
        String DNA2 = br.readLine();

        int l1 = DNA1.length();
        int l2 = DNA2.length();

        int s = 0; // 앞에서 일치한 개수
        int e = 0; // 뒤에서 일치한 개수

        // 앞에서부터 비교
        while (s < l1 && s < l2 && DNA1.charAt(s) == DNA2.charAt(s)) {
            s++;
        }

        // 뒤에서부터 비교
        while (e < l1 && e < l2 &&
               (l1 - e - 1) >= s && (l2 - e - 1) >= s && // 겹침 방지
               DNA1.charAt(l1 - e - 1) == DNA2.charAt(l2 - e - 1)) {
            e++;
        }

        int ans;
        if (s >= Math.min(l1, l2) - e) { // 겹치는 경우
            ans = (l1 > l2) ? 0 : l2 - l1;
        } else {
            ans = l2 - (s + e);
        }

        System.out.println(ans);
    }
}
