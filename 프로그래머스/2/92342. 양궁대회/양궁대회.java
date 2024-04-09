import java.util.Arrays;

class Solution {
        // 완전탐색 - DFS
    static int N, maxMinus;
    static int[] arr;
    static int[] answer = {-1};

    public static int[] solution(int n, int[] info) {
        N = n;
        maxMinus = -1;
        arr = new int[11];
        dfs(info, 0,0);

        return answer;

    }
    // idx = 점수 0 ~ 10 까지 접근
    // cnt = 사용한 화살의 개수 (원소의 총합은 점수가 아닌 개수)
    private static void dfs(int[] apeach, int idx, int cnt) {
        if (idx == 11){
            // 사용 가능한 화살 개수 확인
            // 점수 계산
            if (cnt == N) {
                int apScore = 0,liScore = 0;
                for (int i = 0; i < 11; i++) {
                    // base case
                    if (apeach[i] == 0 && arr[i] == 0) {
                        continue;
                    }
                    if (apeach[i] >= arr[i]) {
                        apScore += 10 - i;
                    }else {
                        liScore += 10 - i;
                    }
                }
                if (liScore > apScore) {
                    // 라이언이 가장 큰 차이로 이기는 경우
                    if (liScore - apScore > maxMinus){
                        maxMinus = liScore - apScore;
                        answer = arr.clone();
                    }
                    // 라이언이 가장 큰 점수 차이로 우승할 수 잇는 방법이 여려개일 경우
                    else if (liScore - apScore == maxMinus) {
                        for (int i = 10; i >= 0; i--) {
                            if (answer[i] < arr[i]) {
                                answer = arr.clone();
                                return;
                            }else if (answer[i] > arr[i])
                                return;

                        }
                    }
                }
            }
            return;
        }

        //둘다 0으로 점수 받기 포기
        if (apeach[idx] == 0) {
            dfs(apeach, idx + 1, cnt);
        }
        // 어피치 이기기
        if (cnt + 1 + apeach[idx] <= N) {
            arr[idx] = apeach[idx] + 1;
            dfs(apeach, idx + 1, cnt + 1 + apeach[idx]);
            arr[idx] = 0;
        }
        // 어피치한테 지기
        if (apeach[idx] != 0) {
            for (int i = 0; i <= apeach[idx]; i++) {
                arr[idx] = i;
                dfs(apeach, idx + 1, cnt + i);
                arr[idx] = 0;
            }
        }
    }
}