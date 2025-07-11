
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        int maxGet = nums.length / 2;
        int keyCnt = numsMap.size();

        if (keyCnt < maxGet)
            return keyCnt;

        return maxGet;
    }
}