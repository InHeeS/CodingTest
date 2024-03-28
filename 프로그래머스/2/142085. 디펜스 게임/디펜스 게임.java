import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public static void main(String[] args) {

        int[] enemy = {4,2,4,5,3,3,1};
        System.out.println(solution(7,3,enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if(n < 0) {
                if (k > 0) {
                    n += (int)pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}