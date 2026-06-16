class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int end = change(video_len);
        int start = change(pos);
        int op_s = change(op_start);
        int op_e = change(op_end);
        
        for(String c : commands){
            
            if(start >= op_s && start < op_e) start = op_e;
            
            // 10초 이전
            if(c.equals("prev")) start = (start - 10 > 0) ? start - 10 : 0;
        
            // 10초 이후
            else start = (start + 10 > end) ? end : start + 10;
        }
        
        if(start >= op_s && start < op_e) start = op_e;
        
        if(start / 60 < 10) answer += "0" + (start / 60) + ":";
        else answer += (start / 60) + ":";
        
        if(start % 60 < 10) answer += "0" + (start % 60);
        else answer += (start % 60);
        
        
        return answer;
    }
    
    private int change(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}