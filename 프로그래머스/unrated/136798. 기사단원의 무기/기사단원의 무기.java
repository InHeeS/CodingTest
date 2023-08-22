import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Solution {
    public int solution(int number, int limit, int power) {
        List<Integer> list = new ArrayList<>();
        int w =0;

        for(int i = 1; i <=number; i++){
            int cnt = countDivisor(i);
            list.add(cnt > limit ? power : cnt);
            w += list.get(i - 1);
        }
        return w;
    }
    public static int countDivisor(int num) {
        int cnt =0;

        for(int i=1; i <= Math.sqrt(num); i++){
            if (i * i != num) {
                if(num % i == 0)
                    cnt+=2;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}