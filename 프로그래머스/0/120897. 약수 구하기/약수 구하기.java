import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= (int)(Math.sqrt(n)) ; i++){
            if(n % i == 0){
                list.add(i);
                if (i != n / i) list.add(n / i);
            }
        }
        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }
        Arrays.sort(answer);
        return answer;
    }
}