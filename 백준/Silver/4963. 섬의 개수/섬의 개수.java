import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            input();
            if (n == 0 || m == 0)break;
            pro();

        }
    }

    private static void pro() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && a[i][j] == 1){
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k <8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)continue;
            if (a[nx][ny] ==0)continue;
            if (visit[nx][ny])continue;
            dfs(nx, ny);

        }
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0, 1},{-1,0},{0, -1},{1,1},{1,-1},{-1, 1},{-1, -1}};

    private static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        visit = new boolean[n][m];
    }

}
