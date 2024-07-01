
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] xs = new int[N];

        for (int i = 0; i < N; i++) {
            xs[i] = sc.nextInt();
        }
        Arrays.sort(xs);

        int l = 1, r = xs[N - 1] - xs[0], ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (calulateCount(xs, m) >= C){
                ans = m;
                l = m +1;
            }else{
                r = m - 1;
            }
        }
        System.out.println(ans);
    }

    private static int calulateCount(int[] xs, int m) {
        int count = 1;
        int passX = xs[0];

        for (int i = 1; i < xs.length; i++) {
            if (xs[i] - passX >= m) {
                passX = xs[i];
                count++;
            }
        }
        return count;
    }

}
