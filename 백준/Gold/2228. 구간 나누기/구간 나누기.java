import java.util.Scanner;

public class Main {

    // 연속된 구간의 합 : 누적합 - 누적합
    // d[n][m] : n 번째 수까지 m 개의 구간으로 나누어 구한 최대 합
    // case 1 : n번째 수를 고르지 않는수 d[n][m] = d[n -1][m]
    // case 2 : 신규 구간을 [i,n] 으로 할당한 경우
    // d[i-2][m-1](서로의 구간이 인접하지 않으니 구간이 (i, n) 이라면 i -1 비워야 하니 i - 2 부분이 맞음
    // [m-1] : 신규 구간을 하나 더해야 m -1 + 1 = m)
    // = d[i-2][m -1] + sum(i,n)
    static int[] a,s;
    static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n +1];
        s = new int[n +1];
        d = new int[n + 1][m +1];
        for (int i = 1; i < n + 1 ; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i -1] + a[i];
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                d[i][j] = -1;
            }
        }

        System.out.println(calc(n,m));
    }

    static int sum(int[] s, int i, int j){
        return s[j] - s[i -1];
    }
    static int calc(int n, int m){
        if (m == 0) return 0;
        if (n <= 0)return -1000000000;
        if (d[n][m] != -1) return d[n][m];

        d[n][m] = calc(n -1, m);
        for (int i = 1; i < n + 1; i++) {
            int temp = calc(i - 2, m - 1) + sum(s, i, n);
            if (d[n][m] < temp){
                d[n][m] = temp;
            }
        }
        return d[n][m];
    }
}
