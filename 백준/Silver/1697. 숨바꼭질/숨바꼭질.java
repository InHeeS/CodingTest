import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        bfs();
        System.out.println(dist[K]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = true;
        dist[N] = 0;

        while(!q.isEmpty()){
            int x = q.poll();
            int y = x - 1;
            if (0 <= y && y <=100000 && !visit[y]){
                visit[y] = true;
                dist[y] = dist[x] + 1;
                q.add(y);
            }
            y = x + 1;
            if (0 <= y && y <=100000 && !visit[y]){
                visit[y] = true;
                dist[y] = dist[x] + 1;
                q.add(y);
            }
            y = x * 2;
            if (0 <= y && y <=100000 && !visit[y]){
                visit[y] = true;
                dist[y] = dist[x] + 1;
                q.add(y);
            }
        }

    }

    private static void input() {
        N = sc.nextInt();
        K = sc.nextInt();
        visit = new boolean[100005];
        dist = new int[100005];
    }

}
