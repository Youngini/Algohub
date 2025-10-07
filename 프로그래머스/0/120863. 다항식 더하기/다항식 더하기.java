class Solution {
    public String solution(String polynomial) {
        int a = 0; // x의 계수 합
        int b = 0; // 상수항 합

        for (String term : polynomial.trim().split(" \\+ ")) {
            if (term.equals("x")) a += 1;
            else if (term.endsWith("x")) a += Integer.parseInt(term.substring(0, term.length() - 1));
            else b += Integer.parseInt(term);
        }

        if (a == 0) return String.valueOf(b);
        if (b == 0) return (a == 1) ? "x" : a + "x";
        return (a == 1 ? "x" : a + "x") + " + " + b;
    }
}
