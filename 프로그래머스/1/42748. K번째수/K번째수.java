import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        int t = commands.length;
        int idx = 0;
        while(idx < t){
            int[] tmp = Arrays.copyOfRange(array,
                commands[idx][0] -1,
                commands[idx][1]);
            Arrays.sort(tmp);

            System.out.println(Arrays.toString(tmp));
            result.add(tmp[commands[idx][2] - 1]);
            idx++;


        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}