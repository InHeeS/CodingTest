
import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        Arrays.sort(a, 1, n + 1);
        long sum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0 ,v3 = 0;
        for (int i = 1; i <= n -2; i++) {
            int target = -a[i];
            int l = i + 1, r = n;
            while(l < r){
                if (sum > Math.abs(-(long) target + a[l] + a[r])){
                    sum = Math.abs(-(long) target + a[l] + a[r]);
                    v1 = -target;
                    v2 = a[l];
                    v3 = a[r];
                }
                if (a[l] + a[r] > target) r--;
                else l++;
            }
        }
        sb.append(v1).append(' ').append(v2).append(' ').append(v3);
        System.out.println(sb);
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] a, b;
    static int n, S;

    private static void input() {
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
    }
}
