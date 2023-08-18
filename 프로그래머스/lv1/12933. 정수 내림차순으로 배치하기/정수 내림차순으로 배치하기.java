import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Solution {
    public long solution(long n) {
        List<Long> list = new ArrayList<>();
        while( n > 0 ){
            list.add(n % 10);
            n /= 10;
        }
        list.sort(Comparator.reverseOrder());
        long rs=0;
        for (Long aLong : list) {
            rs *= 10;
            rs += aLong;
        }
        return rs;
    }
}