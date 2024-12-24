
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        dfs(1);
        for (int i = 1; i <= n ; i++) {
            sb.append(dy[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void dfs(int x) {
        for (int y : children[x]) {
            dy[y] += dy[x];
            dfs(y);
        }
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static ArrayList<Integer>[] children;
    static int[] dy;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        dy = new int[n + 1];
        children = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n ; i++) {
            int par = sc.nextInt();
            if (i == 1)continue;
            children[par].add(i);
        }
        for (int i = 1; i <=m ; i++) {
            int x = sc.nextInt(), v = sc.nextInt();
            dy[x] += v;

        }
    }

}
