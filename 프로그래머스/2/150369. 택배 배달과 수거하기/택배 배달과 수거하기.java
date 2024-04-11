class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0; // 집의 배송 수
        int pickup = 0;  // 집의 수거 수

        for (int i = n - 1; i >= 0; i--) {
            deliver += deliveries[i];
            pickup += pickups[i];

            while (deliver > 0 || pickup > 0) {
                // deliver or pickup 이 음수일때
                //
                deliver -= cap;
                pickup -= cap;
                answer += (i + 1) * 2;
            }
        }

        return answer;
    }

}