import java.util.PriorityQueue;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
   public static int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville) {
            pq.add(sco);
        }

        int mixCount = 0;
        while(!pq.isEmpty()){
            Integer poll1 = pq.poll();
            if (poll1 >= K){
                break;
            }
            if (pq.isEmpty()){
                return -1;
            }
            Integer poll2 = pq.poll();
            pq.add(poll1 + (poll2 * 2));
            mixCount++;
        }

        return mixCount;
    }
}