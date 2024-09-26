
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // d[r][c] = 1행부터 (r,c) 까지 경계선을 그었을때 최소의 부자연 스러움
    // 임이의 열에서 시작 및 끝 은 위치에 상관없다.
    static int[][] dp;
    static int[][][] image;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        final int MAX_VALUE = 1000000000;

        image = new int[2][h+2][w+2];
        dp = new int[h +2][w +2];

        for(int img = 0; img <=1; img++){
            for (int i = 1; i < h +1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    image[img][i][j] = sc.nextInt();
                }
            }
        }
        for (int i = 1; i < h + 1; i++) {
            Arrays.fill(dp[i], MAX_VALUE);
        }
        int answer = MAX_VALUE;
        for(int r = 1; r <= h; r++){
            for(int c = 1; c<= w; c++){
                int case1 = dp[r-1][c-1];
                int case2 = dp[r-1][c];
                int case3 = dp[r-1][c+1];
                int diff = image[0][r][c] - image[1][r][c];
                dp[r][c] = Math.min(case1, Math.min(case2, case3))
                    + (diff * diff);
            }
        }

        for (int i = 1; i < w + 1; i++) {
            answer = Math.min(answer, dp[h][i]);
        }

        System.out.println(answer);
    }

}
