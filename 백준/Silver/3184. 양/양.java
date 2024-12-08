import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && a[i].charAt(j) != '#'){
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if (sheep > wolf) totalSheep += sheep;
                    else totalWolf += wolf;
                }
            }
        }
        sb.append(totalSheep).append(' ').append(totalWolf);
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        if (a[x].charAt(y) == 'o') sheep++;
        if (a[x].charAt(y) == 'v')wolf++;
        visit[x][y] = true;
        for (int k = 0; k <4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)continue;
            if (a[nx].charAt(ny)== '#')continue;
            if (visit[nx][ny])continue;
            dfs(nx, ny);
        }
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, m, totalSheep, totalWolf, sheep, wolf;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0, 1},{0, -1}};

    static String[] a;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }
        visit = new boolean[n][m];
    }

}
