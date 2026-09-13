import java.util.HashMap;
import java.util.Map;
class Solution {
    public static int solution(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pick = nums.length / 2;
        int kind = map.size();
        
        return Math.min(pick, kind);
    }
}