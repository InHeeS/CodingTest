import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    boolean solution(String s) {
        /**
         * 삽입: deque.push(E e)
         * 삭제: deque.pop()
         */
        Deque<Character> deque = new ArrayDeque<>();
        boolean result = true;
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '('){
                deque.push(c);
            }else if (c == ')'){
                if (deque.isEmpty()){
                    return false;
                }
                if (deque.peek() != '(')
                    return false;
                deque.pop();

            }
        }
        return deque.isEmpty();
    }

}