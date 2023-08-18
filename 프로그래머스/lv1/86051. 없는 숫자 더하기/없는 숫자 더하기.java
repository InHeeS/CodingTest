import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i< 10; i++)
            list.add(i);

        int sum =0;
        for (int number : numbers) {
            if (list.contains(number))
                list.remove(Integer.valueOf(number));
        }

        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}