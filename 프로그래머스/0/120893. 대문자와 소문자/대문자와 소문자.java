class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = Character.isLowerCase(c) ? Character.toUpperCase(c)
                                              : Character.toLowerCase(c);
        }
        return new String(arr);
    }
}