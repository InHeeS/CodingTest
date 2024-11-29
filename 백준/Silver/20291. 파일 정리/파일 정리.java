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
        Arrays.sort(a, 1, N + 1);

        for (int i = 1; i <= N;) {
            int cnt = 1, j = i + 1;
            for (;j <= N; j++) {
                if (a[j].compareTo(a[i]) == 0) cnt++;
                else break;
            }

            sb.append(a[i]).append(' ').append(cnt).append('\n');
            i = j;
        }

        System.out.println(sb.toString());
    }

    static int N;
    static String[] a;

    private static void input() {
        N = sc.nextInt();
        sc.nextLine();
        a = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextLine().split("\\.")[1].trim();
        }
    }

}
