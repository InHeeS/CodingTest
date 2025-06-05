class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] expire = new int[24]; // i에 만료되어 active 에서 제거되어야 할 서배 대수
        int active = 0;

        for (int hour = 0; hour < 24; hour++) {
            active -= expire[hour]; // 현재 시간에 만료된 서배 수를 active에서 제거;

            // 올림 연산: ceil(players[hour] / (double)m)
            int required = (players[hour]) / m;

            if (active < required) {
                int diff = required - active;
                answer += diff;
                active += diff;

                // hour + k 시점에 만료되므로 expire[hour + k]에 추가 (만약 24시간 범위 내라면)
                int expireTime = hour + k;
                if (expireTime < 24){
                    expire[expireTime] += diff;
                }
            }

        }

        return answer;
    }
}