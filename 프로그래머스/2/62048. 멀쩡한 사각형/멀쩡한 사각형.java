class Solution {
    public static long solution(int w, int h) {
        long answer =0;
        long x = (long) w;
        long y = (long) h;
        for (long i = 1; i < w; i++) {
            answer += y * i / x; // x 값에 따른 기울기

            
        }

        return answer * 2;
    }
}