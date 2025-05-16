
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int kind = set.size();

        Map<String, Integer> countMap = new HashMap<>();
        int start = 0, end = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0, bestEnd = 0;

        while(end < gems.length){
            // 확장
            countMap.put(gems[end], countMap.getOrDefault(gems[end], 0) + 1);
            end++;

            // 모든 종류 포함 시 축소 시도
            while (countMap.size() == kind){
                // 최단 구간 갱신
                if (end - start < bestLen){
                    bestLen = end - start;
                    bestStart = start;
                    bestEnd = end;
                }

                String leftGem = gems[start];
                if (countMap.get(leftGem) == 1){
                    countMap.remove(leftGem);
                }else{
                    countMap.put(leftGem, countMap.get(leftGem) - 1);
                }
                start++;
            }
        }

        return new int[] {bestStart + 1, bestEnd};
    }
}