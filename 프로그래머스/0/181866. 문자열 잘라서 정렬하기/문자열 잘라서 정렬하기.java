import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        Arrays.sort(answer);
        ArrayList<String> ans = new ArrayList<>();
        for(String s : answer){
            if(!s.equals("")) ans.add(s);
        }
        return ans.toArray(new String[0]);
    }
}