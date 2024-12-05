import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        visit = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            if (visit[i]) continue;
            dfs(i);
            ans++;
        }
        System.out.println(ans);
    }

    private static void dfs(int x) {
        visit[x] = true;

        for (int y : adj[x]) {
            if (visit[y])
                continue;

            dfs(y);
        }
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

}
