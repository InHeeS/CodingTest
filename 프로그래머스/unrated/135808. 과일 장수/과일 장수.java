import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> list = new ArrayList<>();
        for (int j : score) list.add(j);

        list.sort(Comparator.reverseOrder());
        int sum =0;
        int size = list.size();
        int cnt =0;
        while(size >= m){
            sum += list.get(m -1 + m * cnt) * m;
//            list.subList(0, m).clear(); //시간 낭비
            size -= m;
            cnt++;
        }
        return sum;
    }
}