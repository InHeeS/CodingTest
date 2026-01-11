import java.util.Arrays;

class Solution {
    public static int solution(int[] d, int budget) {
        // 최대 지원 부서의 개수 구하기
        // d의 합이 budget 과 같을 필요는 없다.
        // d의 가장 큰 값을 순서로 내려가면서 합이 맞다면 max 값 갱신해주기
        // d의 길이는 100,000 -> o(n) 그리디
        int cnt = 0;
        Arrays.sort(d);
        for (int cost : d) {
            if(cost > budget){
                break;
            }
            budget -= cost;
            cnt++;
        }

        return cnt;
    }
}