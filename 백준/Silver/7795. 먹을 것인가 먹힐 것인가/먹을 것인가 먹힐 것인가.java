
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] A, B;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }

    private static void pro() {
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            // A[i] 를 선택했을 때 B 에서는 A[i]보다 작은 게 몇개 있는 지 count
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    private static int lower_bound(int[] A, int L, int R, int X) {
        // A[L .. R] 에서 X 미만의 수 (X 보다 작은 수) 중 제일 오른 쪽 인덱스를 return
        int result = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                // mid = [L, R] 사이의 개수이며 가장 근접하며 X 보다 작은수를 result 에 담기
                result = mid;
                L = mid + 1;
            } else if (A[mid] >= X) {
                R = mid - 1;
            }
        }
        return result;
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = sc.nextInt();
        }
    }

}
