import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            list.add(n % 3);
            n /= 3;
        }
        Collections.reverse(list);
        double rs =0;
        for(int i=0; i< list.size(); i++){
            rs += list.get(i) * Math.pow(3, i);
        }

        return (int)rs;
    }
}