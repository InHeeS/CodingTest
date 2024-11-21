import java.awt.desktop.SystemEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int n, m, k;
    static String[] board;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Map<String, Integer> M = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine();
        }
    }

    private static void pro() {
        // (i, j) 에서 만들 수 있는 해당 문자열의 수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, Character.toString(board[i].charAt(j)), 1);
            }
        }

        while(k-- >0){
            String chk = sc.nextLine();
            if (M.containsKey(chk)) {
                System.out.println(M.get(chk));
            }else{
                System.out.println(0);
            }
        }
    }


    static void dfs(int i, int j, String path, int len){
        // path d라는 문자열을 만들었음을 기록해주기
        if (M.containsKey(path)) M.put(path, M.get(path) + 1);
        else M.put(path, 1);

        if (len == 5)return;

        for (int dir = 0; dir <8; dir++) {
            int ni = (i + dx[dir]) % n;
            int nj = (j + dy[dir]) % m;
            if (ni < 0) ni += n;
            if (nj < 0) nj += m;

            dfs(ni, nj, path + board[ni].charAt(nj), len + 1);
        }
    }
}
