
import java.util.Scanner;

public class Main {

    public static long[][] mem;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            mem = new long[n + 1][m + 1];

            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= m; k++) {
                    mem[j][k] = -1;
                }
            }
            System.out.println(solve(n,m));
        }
    }

    public static long solve(int i, int last) {
        if (last < 0) return 0;
        if (i == 1) return last;

        if (mem[i][last] == -1) {
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }
        return mem[i][last];
    }

}
