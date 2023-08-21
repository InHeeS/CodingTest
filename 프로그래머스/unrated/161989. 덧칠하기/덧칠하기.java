import java.util.Arrays;
class Solution {
    public int solution(int n, int m, int[] section) {
        int loc = 0, cnt =0;
        for(int i=0; i< section.length; i++){
            if(loc >= section[i])
                continue;
            if(loc < section[i]){
                cnt++;
                loc = section[i] + (m -1);
            }else {
                if (i == section.length -1)
                    break;
                loc = Math.min(loc + (m -1), section[i+1]);
            }
        }
        return cnt;
    }
}