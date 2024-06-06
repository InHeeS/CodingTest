
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 보호받지 못하는 행/열의 개수를 구한다.

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        // row
        int existRowCount = 0;
        for (int i = 0; i < N; i++) {
            boolean exist = false;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    exist = true;
                    break;
                }
            }
            if (exist) existRowCount++;
        }

        // col
        int existColCount = 0;
        for (int i = 0; i < M; i++) {
            boolean exist = false;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 'X') {
                    exist = true;
                    break;
                }
            }
            if (exist) existColCount++;
        }

        int needRowCount = N - existRowCount;
        int needColCount = M - existColCount;

        System.out.println(Math.max(needRowCount, needColCount));
    }

}
