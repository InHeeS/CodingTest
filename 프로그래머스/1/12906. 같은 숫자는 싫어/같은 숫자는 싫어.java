import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        // 배열에서 현재 값이 전의 값과 같다면 continue
        //Integer[] to int[]

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(i == 0)ans.add(arr[i]);
            else{
                if(arr[i] == arr[i - 1]) continue;
                ans.add(arr[i]);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}