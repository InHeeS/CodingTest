
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] len = new int[K];
        for (int i = 0; i < K; i++) {
            len[i] = sc.nextInt();
        }

        long l = 1, r = (1L << 31) - 1;
        int ans = -1;

        while(l <= r ){
            long m = (l + r)/ 2;
            if (calculateCount(len, m) >= N){
                l = m + 1;
                ans = (int)m;
            }else
                r = m - 1;
        }

        System.out.println(ans);
    }

    private static int calculateCount(int[] len, long cutLength) {
        int cnt =0;
        for (int i : len) {
            cnt += i / cutLength;
        }
        return cnt;
    }

}
