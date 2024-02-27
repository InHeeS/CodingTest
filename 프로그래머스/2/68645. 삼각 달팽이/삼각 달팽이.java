class Solution {
    public static int[] solution(int n) {
        int[] answer = new int[(1 + n) * n / 2];
        //idx(현재 위치한 인덱스 값), dis(이동거리), num(배열에 저장할 값)
        int idx = 0;
        int dis = 1;
        int num = 1;

        for (int i = 0; i < n; i++) {
            // i = 진행방향 바뀐 횟수
            // i == 0 일때는 n - 1 번 진행
            // 나머지는 i -> n - i
            if (i == 0){
                answer[0] = num++;
                for (int j = 0; j < n - 1; j++) {
                    idx = idx + dis++;
                    answer[idx] = num++;
                }
            }else if (i % 3 == 1){
                for (int j = 0; j < n - i; j++) {
                    idx++;
                    answer[idx] = num++;
                }
            }else if (i % 3 == 2) {
                for (int j = 0; j < n - i; j++) {
                    idx = idx - dis--;
                    answer[idx] = num++;
                }
            } else{
                for (int j = 0; j < n - i; j++) {
                    idx = idx + dis++;
                    answer[idx] = num++;
                }
            }
        }

        return answer;
    }
}