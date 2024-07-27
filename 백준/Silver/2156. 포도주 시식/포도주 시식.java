import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();


        // case 0 : N번을 선택하지 않은 경우 d[0][n] => N-1 에서 선택가능한 모든 d[0,1,2][n -1] 중에 가장 큰값
        // case 1 : N - 1 선택하지 않고 N번을 선택한 경우 d[1][n] = d[0][n -1] + wine[n]
        // case 2 : N - 1을 선택하고 N번을 선택한 경우 d[2][n] = d[1][n -1] + wine[n]


        int[] wine = new int[n + 3];
        int[][] d = new int[3][n + 3];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }
        d[0][1] = 0;
        d[1][1] = wine[1];
        d[2][2] = wine[1]; // d[1][n-1] +wine[1] = wine[1]
        for (int i = 2; i <= n; i++) {
           d[0][i] = Math.max(d[0][i -1], Math.max(d[1][i -1], d[2][i - 1]));
           d[1][i] = d[0][i -1] + wine[i];
           d[2][i] = d[1][i -1] + wine[i];
        }

        System.out.println(Math.max(d[0][n], Math.max(d[1][n], d[2][n])));
    }

}
