import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = (n - 1) - idx;
        }

        return answer;
    }
}