import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        Arrays.sort(A, 1, N +1);
        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 =0 , L = 1, R = N;

        while (L < R) {
            int sum = A[L] + A[R];
            if (Math.abs(sum) < best_sum) {
                best_sum = Math.abs(sum);
                v1 = A[L];
                v2 = A[R];
            }

            if (sum > 0){
                R--;
            }else
                L++;
        }
        sb.append(v1).append(" ").append(v2);
        System.out.println(sb);
    }

    private static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }

}
