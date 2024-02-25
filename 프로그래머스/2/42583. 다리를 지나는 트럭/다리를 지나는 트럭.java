import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        // 맨처음 비어 잇는 다리 공간 모두를 0으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        if (bridge_length == 1)return truck_weights.length + 1;
        if (truck_weights.length == 1)return bridge_length + 1;

        int idx =0;
        // 현재 다리에 있는 모든 트럭의 무게
        int curWeight =0;
        while(idx < truck_weights.length){
            // 맨 앞 트럭의 무게를 빼준다.
            curWeight -= bridge.poll();
            answer++;

            if (curWeight + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                curWeight += truck_weights[idx++];
            }
            //견딜 수 있는 무게보다 커진다면 0 을 넣는다.
            else
                bridge.offer(0);
        }

        return answer + bridge_length;
    }
}