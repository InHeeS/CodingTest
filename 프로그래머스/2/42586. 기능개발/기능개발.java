import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add((int)Math.ceil((100.0 - progresses[i])/speeds[i]));
        }
        while(!queue.isEmpty()){
            int cnt =1;
            int poll = queue.poll();
            while(!queue.isEmpty() && queue.peek() <= poll){
                queue.poll();
                cnt++;
            }
            ans.add(cnt);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}