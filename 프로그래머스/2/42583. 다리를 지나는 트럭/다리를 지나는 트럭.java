import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int sum = 0; // 다리위의 트럭들의 무게 합 
        int idx = 0;

        while (idx < truck_weights.length) {
            // 1초 경과: 맨 앞 칸(큐의 head) 비우기 → 다리 위에서 빠져나간 트럭(또는 0) 제거
            time++;
            sum -= bridge.poll();

            if (sum + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 건널 때까지 남은 큐 비우기
        while (sum > 0) {
            time++;
            sum -= bridge.poll();
        }

        return time;
    }
}