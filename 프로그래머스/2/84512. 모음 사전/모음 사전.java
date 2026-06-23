import java.util.*;

class Solution {
    ArrayList<String> dict = new ArrayList<>();
    
    public int solution(String word) {
        permutation("");
        return dict.indexOf(word) + 1;
    }
    
    private void permutation(String s) {
        if (!s.isEmpty()) dict.add(s); 
        if (s.length() == 5) return;
        
        String[] alphabet = {"A", "E", "I", "O", "U"};
        for (String a : alphabet) {
            permutation(s + a);
        }
    }
}