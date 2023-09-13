import java.util.Stack;
class Solution {
    public int solution(String s) {
        int cnt =0;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stk = new Stack<>();
            String str = s.substring(i) + s.substring(0, i);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(stk.isEmpty())
                    stk.push(c);
                else if (c == ']' && stk.peek() == '[')
                    stk.pop();
                else if (c == '}' && stk.peek() == '{')
                    stk.pop();
                else if (c == ')' && stk.peek() == '(')
                    stk.pop();
                else stk.push(c);

            }
            if(stk.isEmpty())
                cnt++;
        }

        return cnt;
    }
}