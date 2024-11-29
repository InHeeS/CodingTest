import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int ansCnt = 0;
        ans = new String[N + 1];
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            String X = sc.nextLine();
            if (bin_search(A,1, N, X))
                ans[++ansCnt] = X;
        }

        Arrays.sort(ans, 1, ansCnt + 1);
        sb.append(ansCnt).append("\n");
        for (int i = 1; i <= ansCnt; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bin_search(String[] A, int L, int R, String X) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid].equals(X)){
                return true;
            }

            if (A[mid].compareTo(X) < 0){
                L = mid + 1;
            }else
                R = mid - 1;
        }
        return false;
    }

    static int N, M;
    static String[] A, ans;

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = new String[N + 1];
        sc.nextLine();
        for (int i = 1; i <= N ; i++) {
            A[i] = sc.nextLine();
        }
    }


}
