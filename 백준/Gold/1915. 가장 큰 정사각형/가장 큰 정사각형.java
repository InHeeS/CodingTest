import java.util.Scanner;

public class Main {
    // d[i][j] = (i,j) 를 우측 하단으로 하는 정사각형의 최대 길이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[][] arr = new int[n + 1][m + 1 ];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            String s  = sc.next();
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = s.charAt(j - 1) -  '0';
            }
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr[i][j] == 1){
                    int case1 = dp[i -1][j-1];
                    int case2 = dp[i-1][j];
                    int case3 = dp[i][j - 1];
                    dp[i][j] = Math.min(case1, Math.min(case2, case3)) + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        System.out.println(max * max);
    }

}
