import java.util.*;
class Solution {
    List<String> words = new ArrayList<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        makeWord("");
        return words.indexOf(word) + 1;   // 0-based → 1-based
    }

    private void makeWord(String s) {
        if (s.length() == 5) return;
        for (char c : vowels) {
            String next = s + c;
            words.add(next);
            makeWord(next);
        }
    }
}