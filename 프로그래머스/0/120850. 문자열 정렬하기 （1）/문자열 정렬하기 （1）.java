class Solution {
    public int[] solution(String my_string) {
        return my_string.chars()                 // 문자 코드 스트림
                .filter(Character::isDigit)      // 숫자만
                .map(c -> c - '0')               // 문자→숫자
                .sorted()                        // 오름차순
                .toArray();                      // int[]
    }
}
