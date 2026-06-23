class Solution {
    public int[] solution(int brown, int yellow) {
        int tmp = (brown - 4) / 2;
        
        for(int i = 1; i < tmp - 1; i++){
            int w = i + 2;
            int h = tmp - i + 2;
            
            if((w - 2) * (h - 2) == yellow) return new int[]{h, w};
        }
        return new int[]{3,3};
    }
}