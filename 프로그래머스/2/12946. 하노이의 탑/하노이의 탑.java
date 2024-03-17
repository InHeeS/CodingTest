import java.util.ArrayList;
import java.util.List;
class Solution {
    private static List<int[]> arr = new ArrayList<>();


    // N-1개 출발지 -> 경유지
    // 1개 출발지 -> 도착지
    // N -1개 경유지 -> 도착지의 규칙을 가진다.
    public static int[][] solution(int n) {
        move(n, 1,2,3);
        int[][] answer = arr.stream().toArray(int[][]::new);
        return answer;
    }

    private static void move(int cnt, int start, int mid, int end) {
        if(cnt == 0)
            return ;

        move(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end});
        move(cnt -1, mid, start, end);
    }
}