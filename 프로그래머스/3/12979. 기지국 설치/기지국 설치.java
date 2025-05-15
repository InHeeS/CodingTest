import java.util.Arrays;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverWidth = 2 * w + 1;
        int current = 1; // start idx

        Arrays.sort(stations);

        for (int s : stations) {
            int gapStart = s - w;
            if (gapStart > current){
                int length = gapStart - current;
                // 올림 수식
                answer += (length + coverWidth - 1) / coverWidth;
            }
            int gapEnd = s + w;
            current = Math.max(current, gapEnd + 1);
            if (current > n )break;
        }

        if (current <= n){
            int length = n - current + 1;
            answer += (length + coverWidth - 1) / coverWidth;
        }


        return answer;
    }
}