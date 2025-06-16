import java.util.Arrays;

class Solution {
private int[] diffs, times;
    private long limit;
    private int n;

    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        this.n = diffs.length;

        // 1. 탐색 범위 결정
        // diffs[0] = 1
        int maxDiff = Arrays.stream(diffs).max().orElse(1);
        int left = 1, right = maxDiff, answer = maxDiff;

        while(left <= right){
            int mid = (left + right) / 2;
            if (canFinishWithin(mid)) {
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
    // 주어진 level 로 전체 퍼즐을 limit 안에 풀 수 있는지 판단하는 함수
    private boolean canFinishWithin(int level) {
        long totalTime = 0L;
        for (int i = 0; i < n; i++) {
            if (diffs[i] <= level){
                totalTime += times[i];
            }else{
                int wrongCount = diffs[i] - level;
                // i == 0 diffs[0] = 1, level >= 1 이므로 여기로 가지 않음
                long replayCost = (long) wrongCount * (times[i] + times[i - 1]);
                totalTime += replayCost + times[i];
            }
            
            if (totalTime > limit) return false;
        }
        return true;
    }
}