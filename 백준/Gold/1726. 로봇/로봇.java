import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // d[][][] = 방향을 가진 인접행렬 위치
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m +1][n +1];
        int[][][] dist = new int[5][m + 1][n + 1];

        final int EAST =1, WEST =2, SOUTH =3, NORTH = 4;
        for (int i = 1; i < m +1; i++) {
            for (int j = 1; j < n+ 1 ; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Point start = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point end = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

        // 동서 남북
        int[] dr = {0, 0,0,1,-1};
        int[] dc = {0,1,-1,0,0};
        for (int i = 1; i < m+ 1; i++) {
            for (int j = 1; j < n +1 ; j++) {
                for (int k = 1; k < 5; k++) {
                    dist[k][i][j] = -1;
                }
            }
        }
        dist[start.dir][start.r][start.c] = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Point now = q.poll();
            // 전진 구현
            for (int i = 1; i <= 3 ; i++) {
                int nr = now.r + dr[now.dir] * i;
                int nc = now.c + dc[now.dir] * i;

                if (!isRange(nr,nc,m,n))break;
                if (a[nr][nc] == 1)break;
                if (dist[now.dir][nr][nc] != -1) continue;

                dist[now.dir][nr][nc] = dist[now.dir][now.r][now.c] + 1;
                q.add(new Point(nr, nc, now.dir));
            }
            // 방향 구현
            for (int i = 1; i <= 4; i++) {
                if (i == now.dir)continue;
                if (dist[i][now.r][now.c] != -1)continue;
                int cnt;
                switch (i) {
                    case EAST:
                    case WEST:
                        cnt = (now.dir == NORTH || now.dir == SOUTH) ? 1 : 2;
                        break;
                    case SOUTH:
                    case NORTH:
                        cnt = (now.dir == EAST || now.dir == WEST) ? 1 : 2;
                        break;
                    default:
                        cnt = 0;
                        break;
                }
                dist[i][now.r][now.c] = dist[now.dir][now.r][now.c] + cnt;
                q.add(new Point(now.r, now.c, i));
            }
        }
        System.out.println(dist[end.dir][end.r][end.c]);
    }

    static boolean isRange(int r, int c, int m, int n){
        return r >= 1 && r <= m && c >= 1 && c <= n;
    }
}

class Point{
    int r, c, dir;

    public Point(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}
