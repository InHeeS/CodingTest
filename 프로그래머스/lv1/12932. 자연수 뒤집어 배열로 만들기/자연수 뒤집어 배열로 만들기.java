import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(long n) {
        List<Long> list = new ArrayList<>();
        while(n > 0){
            list.add(n % 10);
            n /= 10;
        }
        long[] arr = new long[list.size()];
        for(int i=0 ;i< list.size(); i++){
            arr[i] = list.get(i);
        }

        int[] intArr = Arrays.stream(arr).mapToInt(i -> (int)i).toArray();
        return intArr;
    }
}