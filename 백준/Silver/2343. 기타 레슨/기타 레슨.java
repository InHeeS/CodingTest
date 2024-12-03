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
        int l = a[1], r = 1000000000, ans = 0;
        for (int i =1; i <= n ; i++) {
            // 적어도 제일 긴 녹화본의 길이만큼은 필요하다
            l = Math.max(l, a[i]);
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (determination(mid)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean determination(int len) {
        int sum = 0, cnt = 1;
        for (int i = 1; i <= n ; i++) {
            // a[i] > len 해당 수식은 성립하지 않음
            if (sum + a[i] > len) {
                cnt++;
                sum = a[i];
            }else{
                sum += a[i];
            }
        }
        return cnt <= m;
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n+ 1];
        for (int i = 1; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
    }

}
