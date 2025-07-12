import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /**
         * deque
         *
         */
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 남은 일수 만약 3.4 라면 4일
            queue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while(!queue.isEmpty()){
            int cnt = 1;
            int poll = queue.poll();
            while(!queue.isEmpty() && queue.peek() <= poll){
                queue.poll();
                cnt++;
            }
            result.add(cnt);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}