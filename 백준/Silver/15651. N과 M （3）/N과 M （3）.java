
import java.util.Scanner;

public class Main {


    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];

        rec_func(1);
        System.out.println(sb.toString());
    }

    private static void rec_func(int k) {

        if (k == M + 1) {
            for (int i = 1; i <= M; i++)sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

}
