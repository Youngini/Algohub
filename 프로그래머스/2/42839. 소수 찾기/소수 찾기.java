import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        int[] arr = new int[numbers.length()];
        int i = 0;
        for(char c : numbers.toCharArray()) arr[i++] = c - '0';
        boolean[] isUsed = new boolean[arr.length];
        
        Permutation("",arr ,isUsed);
        
        int cnt = 0;
        for(int s : set){ 
            if(isPrime(s)) cnt++;
        }
        
        return cnt;
        
    }
    
    private void Permutation(String s, int[] arr, boolean isUsed[]){
        for(int i = 0 ; i < arr.length; i++){
            if(!isUsed[i]){
                String tmp = s + arr[i];
                isUsed[i] = true;
                set.add(Integer.parseInt(tmp));
                Permutation(tmp, arr, isUsed);
                isUsed[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}