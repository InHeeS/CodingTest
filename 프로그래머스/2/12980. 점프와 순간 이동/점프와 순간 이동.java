import java.util.*;

public class Solution {

    // top-bottom -> 메모이제이션, 하향식 방법
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            // 점프 최소화 
            if (n % 2 == 1) {
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }
}