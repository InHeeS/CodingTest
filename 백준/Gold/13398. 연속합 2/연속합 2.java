import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[][] d = new int[2][n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        d[0][0] =a[0];
        int ans  = d[0][0];
        for (int i = 1; i < n; i++) {
            // 포기 하지 않는 수열
            d[0][i] = Math.max(d[0][i-1], 0) + a[i];
            // 1개의 수를 포기한다.
            d[1][i] = Math.max(d[1][i-1] + a[i], d[0][i-1]);
            ans = Math.max(ans, Math.max(d[0][i], d[1][i]));

        }

        System.out.println(ans);
    }



}
