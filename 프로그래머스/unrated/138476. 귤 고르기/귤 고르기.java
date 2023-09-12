import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1)); // 내림차순
            }
        });
        int cnt =0;
        for (Integer integer : list) {
            if(k <= 0)
                break;
            cnt++;
            k -= map.get(integer);
        }
        return cnt;
    }
}