import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int solution(int[][] sizes) {
        List<Integer> list = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for(int i =0 ; i <sizes.length;i++){
            for(int j =0 ; j < sizes[i].length; j++){
                if(sizes[i][0] >= sizes[i][1])
                    secondList.add(sizes[i][1]);
                else
                    secondList.add(sizes[i][0]);
                list.add(sizes[i][j]);
            }
        }
        secondList.sort(Comparator.reverseOrder());
        list.sort(Comparator.reverseOrder());

        return list.get(0) * secondList.get(0);
    }
}