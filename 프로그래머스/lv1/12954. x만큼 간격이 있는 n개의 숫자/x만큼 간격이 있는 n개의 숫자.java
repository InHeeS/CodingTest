import java.util.ArrayList;
import java.util.List;

class Solution {
    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        for(int i=0; i< n; i++){
            list.add((long)x + (long)x*i);
        }

        long[] arr = new long[list.size()];
        for(int i=0 ;i< list.size(); i++){
            arr[i] = list.get(i).longValue();
        }
        
        return arr;
    }
}