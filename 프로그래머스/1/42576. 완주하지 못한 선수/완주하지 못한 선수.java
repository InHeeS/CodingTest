import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
class Solution {
    public static String solution(String[] participant, String[] completion) {
        // put hashmap
        // value == false;
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        return map.keySet().stream()
                .filter(e -> map.get(e) > 0)
                .findFirst()
                .get();
    }
}