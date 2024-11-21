import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int X, Y, R, ans, n, m;
    static int[][] a, backup;

    public static void main(String[] args) {
        input();
        pro();
    }
    // 게임 순서에 맞게 진행시킨다.
    private static void pro() {
        for (int rep = 1; rep <= R; rep++) {
            int X, Y;
            String dir;

            X = sc.nextInt();
            Y = sc.nextInt();
            dir = sc.next();

            attack(X, Y, dir.charAt(0));

            X = sc.nextInt();
            Y = sc.nextInt();
            a[X][Y] = backup[X][Y];

        }

        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 0) {
                    System.out.print("F ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }

    }

    private static void attack(int x, int y, char dir) {
        if (a[x][y] == 0) return;

        int dx = 0, dy = 0;
        if (dir == 'E') dy = 1;
        else if (dir == 'W') dy = -1;
        else if (dir == 'S') dx = 1;
        else dx = -1;

        // 현재 도미노의 높이
        int cnt = a[x][y];
        while(x >= 1 && x <= n && y >= 1 && y <= m && cnt >= 1){
            if (a[x][y] != 0)ans++;
            cnt = Math.max(cnt - 1, a[x][y] - 1);

            a[x][y] = 0;
            x += dx;
            y += dy;
        }

    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        R = sc.nextInt();

        a = new int[n + 1][m + 1];
        backup = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                backup[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n ; i++) {
            a[i] = Arrays.copyOf(backup[i], m + 1);
        }
    }

}
