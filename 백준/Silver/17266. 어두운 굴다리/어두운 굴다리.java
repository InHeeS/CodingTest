
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    static Scanner sc = new Scanner(System.in) ;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] a;


    private static void pro() {
        int l = 0, r = n, ans = n;
        Arrays.sort(a, 1, m + 1);

        while(l <= r){
            int mid = (l + r) / 2;
            if (determination(mid)){
                ans = mid;
                // 최소의 높으를 찾기위해
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean determination(int height) {
        int last = 0; // 마지막 밝혀진 위치
        for (int i = 1; i <= m ; i++) {
            if (a[i] - last <= height){
                last = a[i] + height;
            }else{
                return false;
            }
        }
        return last >= n;
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[m + 1];
        for (int i = 1; i <= m ; i++) {
            a[i] = sc.nextInt();
        }

    }

}
