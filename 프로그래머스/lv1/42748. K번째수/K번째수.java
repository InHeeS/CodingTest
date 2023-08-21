import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
class Solution {
        public void main(String[] args) {
        int[] arr = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(solution(arr, commands)));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] rs = new int[commands.length];
        List<Integer> list = new ArrayList<>();
//        System.out.println(commands.length);
        for(int i=0; i< commands.length; i++){
              for(int j = commands[i][0] -1; j <= commands[i][1] -1; j++){
                  list.add(array[j]);
              }
              list.sort(Comparator.naturalOrder());
              rs[i] = list.get(commands[i][2] - 1);
              list.clear();
        }
        return rs;
    }
}