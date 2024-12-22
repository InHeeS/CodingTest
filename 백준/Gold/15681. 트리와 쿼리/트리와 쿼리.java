import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n, r, q;
    static ArrayList<Integer>[] con;
    static int[] dy;

    public static void main(String[] args) {
        input();
        pro();
    }

    static StringBuilder sb = new StringBuilder();

    private static void pro() {
        dy = new int[n + 1];
        
        dfs(r, -1);

        for (int i = 1; i <= q ; i++) {
            int Q = sc.nextInt();
            sb.append(dy[Q]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int prev) {
        dy[x] = 1;
        for (int y : con[x]) {
            if (y == prev)continue;
            dfs(y, x);
            dy[x] += dy[y];
        }
    }

    private static void input() {
        n = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();
        con = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < n ; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            con[x].add(y);
            con[y].add(x);

        }
    }

}
