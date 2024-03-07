class Solution {
    // 탐색 시간을 줄이기 -> 한번의 탐색
    public static long solution(long k, long d) {
        long answer = 0;

        for (long i = 0; i <= d; i+=k) {
            // x 좌표를 k 만큼 늘려준다.
            // a*k 만큼(a = 1,2,3,4...)
            long maxY = (long)Math.sqrt(d*d - i*i);
            answer += maxY / k + 1; // (i,0) 좌표 포함

        }
        return answer;
    }
}