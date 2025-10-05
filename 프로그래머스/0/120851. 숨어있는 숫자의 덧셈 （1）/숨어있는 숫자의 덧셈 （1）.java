class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int[] arr = my_string.chars()
                    .filter(Character::isDigit)
                    .map(c -> c - '0')
                    .toArray();
        for(int i = 0; i < arr.length; i++) answer += arr[i];
        return answer;
    }
}