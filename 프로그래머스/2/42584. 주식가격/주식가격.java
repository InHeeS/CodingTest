import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = (prices.length - 1) - idx;
        }

        return result;
    }
}