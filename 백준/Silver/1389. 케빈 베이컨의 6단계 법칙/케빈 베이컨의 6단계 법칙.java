import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        dist = new int[n +1];
        int minV = bfs(1), minIdx = 1;
        for (int i = 2; i <= n ; i++) {
            int v = bfs(i);
            if (minV > v){
                minV = v;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }

    private static int bfs(int start) {
        int ret = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            dist[i] = -1;
        }

        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            ret += dist[x];

            for (int y : adj[x]) {
                if (dist[y] != -1)continue;
                q.add(y);
                dist[y] = dist[x] + 1;
            }
        }

        return ret;

    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}
