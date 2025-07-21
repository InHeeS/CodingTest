import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

class Solution {
      public int solution(int[][] sizes) {
        int len = sizes.length;
        Arrays.sort(sizes, Comparator.comparingInt((int[] a) -> a[0]).reversed());

        int rowLen = 0;
        int colLen = 0;
        for (int i = 0; i < len; i++) {
            if (sizes[i][0] > rowLen){
                rowLen = sizes[i][0];
            }

            if (sizes[i][1] > sizes[i][0]){
                if (sizes[i][1] > rowLen){
                    rowLen = sizes[i][1];
                }
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }

            if (sizes[i][1] > colLen){
                colLen = sizes[i][1];
            }
        }

        return rowLen * colLen;
    }

}