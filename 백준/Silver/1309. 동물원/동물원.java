import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // d[n] = n * 2 배열에 사자를 배치하는 경우의 수
        // n - 1 번째 경우를 이용하려고 하니 인접한 칸에 사자를 배치할 수 없다.
        // 즉 case 세가지 n -1 왼쪽 -> n 오른쪽 또는 반대, n - 1 에 어느곳도 배치가 안되있을때
        // d[left, right, none][n]

        Scanner sc =new Scanner(System.in);

        final int NONE = 0;
        final int LEFT = 1;
        final int RIGHT = 2;

        int n = sc.nextInt();
        int[][] d= new int[3][n +1];

        // 배치하는 경우의수
        d[LEFT][1] = 1;
        d[RIGHT][1] = 1;
        d[NONE][1] = 1;

        for (int i = 2; i <= n ; i++) {
            d[LEFT][i] = (d[RIGHT][i - 1] + d[NONE][i -1]) % 9901;
            d[RIGHT][i] = (d[LEFT][i - 1] + d[NONE][i -1]) % 9901;
            d[NONE][i] = (d[RIGHT][i - 1] + d[LEFT  ][i -1] + d[NONE][i -1]) % 9901;
        }

    System.out.println((d[LEFT][n] + d[RIGHT][n] + d[NONE][n]) % 9901);
    }

}
