import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int m = sc.nextInt();
        Arrays.sort(a, 1, n +1);

        for (int i = 1; i <= m ; i++) {
            int x = sc.nextInt();
            if (bin_search(a,1,n,x)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bin_search(int[] a, int L, int R, int x) {
        while(L <= R){
            int mid =(L + R) / 2;
            if (a[mid] == x)
                return true;
            if (a[mid] < x){
                L = mid + 1;
            }else
                R = mid - 1;
        }
        return false;
    }

    private static void input() {
        n = sc.nextInt();
        a = new int[n +1];
        for (int i = 1; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
    }

}
