import java.util.Arrays;

class Solution {
    public static int solution(int[][] targets) {
        // 요격 미사일은의 x 좌표는 실수
        // 개구간 (4,5) -> x 좌표는 4,5가 될 수 없다.
        // 투포인터의 합, 끝나는 시간으로 오름차순을 하고, 반복하면서 시점과 종점 비교
        int answer = 0;

        Arrays.sort(targets, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } // 끝나는 시점이 같다면 시작 시점 기준 오름차순
            return o1[1] - o2[1];// 끝나는 시점 오름차순
        }));

        int end = targets[0][1];
        answer++;

        for (int[] target : targets) {
            if (target[0] >= end) {
                end = target[1];
                answer++; // 시점이 요걱 시스템의 상한보다 오른쪽에 있기 때문에 새로운 요격 시스템 추가
            }
        }

        return answer;
    }
}