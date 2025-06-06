import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A, cnt;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {

        Arrays.sort(A, 1, N + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if(func(i)) ans++;
        }

        System.out.println(ans);
    }

    private static boolean func(int target_idx) {
        int L = 1, R = N;
        int target = A[target_idx];
        while(L < R){
            if (L == target_idx)L++;
            else if (R == target_idx)R--;
            else{
                if (A[L] + A[R] == target) return true;
                if (A[L] + A[R] > target) R--;
                else L++;
            }
        }
        return false;
    }

    private static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        cnt = new int[100000 + 1];
    }


}
