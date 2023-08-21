import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list =new ArrayList<>();
        for(int i=0; i< numbers.length -1; i++){
            for(int j = i + 1; j < numbers.length;  j++){
                list.add(numbers[i] + numbers[j]);
            }
        }
        list.sort(Comparator.naturalOrder());
        return list.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}