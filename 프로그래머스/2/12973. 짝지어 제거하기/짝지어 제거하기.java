import java.util.Stack;

class Solution
{
    public static int solution(String s)
    {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : ch) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}