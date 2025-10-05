import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        return numbers[0] * numbers[1] > numbers[n - 1] * numbers[n - 2] ? numbers[0] * numbers[1] : numbers[n - 1] * numbers[n - 2];
    }
}