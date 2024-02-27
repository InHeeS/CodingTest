import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public static int solution(int[] order) {
        int answer = 0; // 실린 상자 개수
        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 0;

        for (int i = 1; i <= order.length; i++) {
            // 보조 컨테이너에 넣기
            if(order[idx] != i)
                deque.addLast(i);
            else {
                idx++;
                answer++;
            }

            while(!deque.isEmpty() && deque.peekLast() == order[idx]){
                deque.removeLast();
                idx++;
                answer++;
            }
//            System.out.println(deque.peekLast());
        }

        return answer;

    }
}