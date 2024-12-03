import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in) ;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] a;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int l = 0, r = 0, ans = 0;
        for (int i = 1; i <= n ; i++) {
            r = Math.max(r, a[i]);
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (determination(mid)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        System.out.println(ans);

    }

    private static boolean determination(int limit) {
        int sum =0;
        for (int i = 1; i <= n ; i++) {
            sum += Math.min(a[i], limit);
        }
        return sum <= m;
    }

    private static void input() {
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();
    }
}
