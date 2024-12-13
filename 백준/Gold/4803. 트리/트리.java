import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    static int n,m, vertex_cnt, edge_cnt;

    public static void main(String[] args) {
        for (int tt = 1;;tt++){
            input();
            if (n == 0 && m == 0) break;
            pro(tt);
        }
        System.out.print(sb);
    }

    private static void pro(int tt) {
        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            if (visit[i])continue;
            vertex_cnt = 0;
            edge_cnt = 0;
            dfs(i);
            // 무방향 그래프
            if (edge_cnt == (vertex_cnt - 1) * 2)ans++;
        }


        // 정답 출력하기
        sb.append("Case ").append(tt).append(": ");
        if (ans == 0){
            sb.append("No trees.\n");
        } else if (ans == 1){
            sb.append("There is one tree.\n");
        } else {
            sb.append("A forest of ").append(ans).append(" trees.\n");
        }
    }

    private static void dfs(int x) {
        vertex_cnt++;
        // 무방향 그래프
        edge_cnt += adj[x].size();
        visit[x] = true;
        for (int y : adj[x]) {
            if (visit[y])continue;
            dfs(y);
        }
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m ; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

}
