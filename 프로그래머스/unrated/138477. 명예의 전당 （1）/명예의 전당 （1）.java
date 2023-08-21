import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] rs = new int[score.length];
        List<Integer> list =new ArrayList<>();

        for(int i=0; i<score.length;i++){
            list.add(score[i]);
            list.sort(Comparator.reverseOrder());

            if(list.size() > k)
                list.remove(list.size() - 1);

            rs[i] = list.get(list.size() -1);
        }
        return rs;
    }
}