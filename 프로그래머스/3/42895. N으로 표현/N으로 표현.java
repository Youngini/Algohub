import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Set<Integer>[] s = new HashSet[9];
        for (int i = 0; i <= 8; i++) s[i] = new HashSet<>();
        
        long base = 0;
        for (int i = 1; i <= 8; i++) {
            base = base * 10 + N;
            s[i].add((int) base);
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int a : s[j]) {
                    for (int b : s[k]) {
                        s[i].add(a + b);
                        s[i].add(a - b);
                        s[i].add(a * b);
                        if (b != 0) s[i].add(a / b);
                    }
                }
            }
            
            if (s[i].contains(number)) return i;
        }
        
        return -1;
    }
}