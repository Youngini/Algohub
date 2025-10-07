class Solution {
    public int solution(String[] babbling) {
        int ans = 0;
        for (String s : babbling) {
            int i = 0;
            boolean usedAya = false, usedYe = false, usedWoo = false, usedMa = false;
            boolean ok = true;

            while (i < s.length()) {
                if (i + 3 <= s.length() && s.startsWith("aya", i)) {
                    if (usedAya) { ok = false; break; }
                    usedAya = true; i += 3;
                } else if (i + 2 <= s.length() && s.startsWith("ye", i)) {
                    if (usedYe) { ok = false; break; }
                    usedYe = true; i += 2;
                } else if (i + 3 <= s.length() && s.startsWith("woo", i)) {
                    if (usedWoo) { ok = false; break; }
                    usedWoo = true; i += 3;
                } else if (i + 2 <= s.length() && s.startsWith("ma", i)) {
                    if (usedMa) { ok = false; break; }
                    usedMa = true; i += 2;
                } else {
                    ok = false; break; // 어떤 토큰과도 매칭 안 됨
                }
            }
            if (ok && i == s.length()) ans++;
        }
        return ans;
    }
}
