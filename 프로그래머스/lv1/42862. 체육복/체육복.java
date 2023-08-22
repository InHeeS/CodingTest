import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int rs = n - lost.length;
        //List remove 함수에서 index 가 앞으로 밀리는 현상 array 로 해결
        // 반례
        // 정렬 필수
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    rs++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }

        for (int j : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == j + 1 || reserve[i] == j - 1) {
                    rs++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return rs;
    }
}