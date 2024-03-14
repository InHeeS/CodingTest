import java.util.Arrays;
class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // data[col] = col - 1 번째 튜플
        col -= 1;
        row_begin -= 1;
        
        
        int finalCol = col;
        Arrays.sort(data, ((o1, o2) -> {
            if(o1[finalCol] == o2[finalCol])
                return o2[0] - o1[0]; // 내립차순
            return o1[finalCol] - o2[finalCol];
        }));
        // S_i 합 구하기
        for (int i = row_begin; i < row_end ; i++) {
            int finalI = i + 1; // data[i][j] => i + 1 번째 튜플의 j + 1 번째 컬럼의 값
            int dataTotal = Arrays.stream(data[i])
                .map(o -> o % finalI)
                .sum();

            answer = answer ^ dataTotal;
        }

        return answer;
    }
}