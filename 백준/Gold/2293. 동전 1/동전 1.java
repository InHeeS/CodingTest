import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // dp[k]: k원을 만드는 경우의수
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i <n; i++) {
            coin[i] = sc.nextInt();
        }
        // 동전을 아무것도 쓰지 않는다.
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + coin[i] <= k; j++) {
                dp[j + coin[i]] += dp[j];
//                System.out.println(j + " : " + dp[j]);
            }
        }

        System.out.println(dp[k]);
    }

}
