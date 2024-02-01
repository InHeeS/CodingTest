import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            int x = (int)(i / n);
            int y = (int)(i % n);
            int value = Math.max(x, y) + 1;
            list.add(value);
        }
        return list.stream().mapToInt(i-> i).toArray();
    }
}