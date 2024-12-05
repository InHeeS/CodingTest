import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int r = 0, ans = -1, sum =0;
        for (int l = 1; l <= n ; l++) {
            while(r < n && sum < k){
                r++;
                if (a[r] == 1)sum++;
            }

            if (sum == k){
                if (ans == -1) ans = r - l + 1;
                ans = Math.min(ans, r - l + 1);
            }

            if (a[l] == 1)sum--;
        }
        System.out.println(ans);
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] a;

    private static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
    }

}
