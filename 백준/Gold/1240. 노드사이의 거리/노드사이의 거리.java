import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, m, ans;
    static ArrayList<Edge>[] con;

    static class Edge{
        int y, c;

        public Edge(int y, int c) {
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        input();
        while(m-- > 0){
            pro();
        }
    }

    private static void pro() {
        int x = sc.nextInt(), y = sc.nextInt();
        dfs(x, -1, y, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int prev, int goal, int dist) {
        if (x == goal){
            ans = dist;
            return;
        }
        for (Edge e : con[x]) {
            if (e.y == prev)continue;
            dfs(e.y, x, goal, dist + e.c);
        }
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        con = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < n ; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
            con[x].add(new Edge(y, c));
            con[y].add(new Edge(x, c));
        }
    }

}
