import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();

    }

    private static void pro() {
        bfs();
        while (m-- > 0) {
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            System.out.print(dist[ex][ey] + " ");
        }
    }

    private static void bfs() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        dist[sx][sy] = 0;
        q.add(sx);
        q.add(sy);

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                q.add(nx);
                q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int sx, sy;
    static int[][] dist;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        dist = new int[n + 1][n + 1];
    }

}
