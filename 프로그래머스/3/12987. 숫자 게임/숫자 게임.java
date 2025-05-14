import java.util.TreeMap;
class Solution {
    public int solution(int[] A, int[] B) {
        TreeMap<Integer, Integer> multiSet = new TreeMap<>();
        for (int b : B) {
            multiSet.put(b, multiSet.getOrDefault(b, 0) + 1);
        }
        int score = 0;
        for (int a : A) {
            // A팀 수 a보다 큰 최소 B팀 수 선택
            // higherKey(a): 키가 a보다 큰 것 중 가장 작은 키를 반환, 없으면 null
            Integer pick = multiSet.higherKey(a);
            if (pick == null) {
                // 가장 작은 수로 희생
                pick = multiSet.firstKey();
            }else{
                score++;
            }
            // 선택한 숫자(pick)를 멀티셋에서 제거하거나 빈도수 감소
            // 현재 pick의 남은 개수 조회
            int cnt = multiSet.get(pick);
            if (cnt == 1)multiSet.remove(pick);
            else multiSet.put(pick, cnt - 1);
        }
        return score;
    }
}