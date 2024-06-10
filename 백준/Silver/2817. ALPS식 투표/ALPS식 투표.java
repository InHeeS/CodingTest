
import java.util.Scanner;

public class Main{

    static class Score{

        public Score(int staffIndex, double arr) {
            this.staffIndex = staffIndex;
            this.arr = arr;
        }

        int staffIndex;
        double arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        double validCut = X * 0.05;
        boolean[]validCandidate = new boolean[26];
        int[] staffValue = new int[26];
        int candidateCount = 0;
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int vote = sc.nextInt();
            if (vote >= validCut){
                int index = name.charAt(0) - 'A';
                validCandidate[index] = true;
                staffValue[index] = vote;
                candidateCount++;
            }
        }

        // 남은 스태프마다 받은 득표수를 1 ~ 14로 나누 점수 집합을 구한다.
        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (validCandidate[i]){
                for (int j = 1; j <= 14; j++) {
                    scores[scoreIndex++] = new Score(i, (double)staffValue[i]/j);
                }
            }

        }

        // 전체 점수 집합에서 점수가 큰 1~14번째 스태프에게 칩을 한개씩 지급한다.
        sortScoresDescendingOrder(scores);

        int[] ans = new int[26];
        for (int i = 0; i < 14; i++) {
            // 내림차순으로 되어있기 때문에
            ans[scores[i].staffIndex]++;
        }
        // 스태프 이름에 대해 사전순으로 후보스태프와 받은 칩의 수를 출력한다.
        for (int i = 0; i < 26; i++) {
            if (validCandidate[i]) {
                System.out.println((char)(i + 'A') + " " + ans[i]);
            }
        }
    }

    private static void sortScoresDescendingOrder(Score[] scores) {
        for (int i = 0; i <scores.length; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[i].arr > scores[j].arr){
                    Score cur = scores[i];
                    for (int k = i; k > j; k--) {
                        scores[k] = scores[k - 1];
                    }
                    scores[j] = cur;
                }

            }
        }
    }

}
