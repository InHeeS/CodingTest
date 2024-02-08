import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] priorities, int location) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            queue.offer(priority);
        }

        while(!queue.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if(queue.peek() == priorities[i]){
                    queue.poll();
                    ans++;

                    if(location == i){
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}