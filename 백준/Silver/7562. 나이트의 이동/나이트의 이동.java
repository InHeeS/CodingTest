import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            input();
            pro();
        }
    }

    private static void pro() {
        System.out.println(bfs());
    }

    private static int bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        dist[sx][sy] = 0;
        queue.add(sx);
        queue.add(sy);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)continue;
                if (dist[nx][ny] != -1) continue;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        return dist[ex][ey];
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, sx, sy, ex, ey;
    static int[][] dist;
    static int[][] dir = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};
    
    
    
    private static void input() {
        n = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        ex = sc.nextInt();
        ey = sc.nextInt();
        dist = new int[n][n];
    }
    
    

}
