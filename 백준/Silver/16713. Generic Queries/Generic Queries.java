
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        // xor 복원 가능 '0' 값은 항등원이 된다.
        // 1 ^ 0 = 1, 0 ^ 0 = 0

        Scanner sc = new Scanner(System.in);

        int N =sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] acc =new int[N +1];
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] ^ arr[i];
        }
        int ans = 0;
        while(Q-- > 0){
            int s = sc.nextInt();
            int e = sc.nextInt();

            ans ^= acc[e] ^ acc[s - 1];
        }

        System.out.println(ans);
    }
}
