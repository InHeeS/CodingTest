import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (j % divisor == 0)
                list.add(j);
        }
        if(list.isEmpty())
            list.add(-1);
        
        list.sort(Comparator.naturalOrder());
        int[] rs = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            rs[i] = list.get(i);
        return rs;
    }
}