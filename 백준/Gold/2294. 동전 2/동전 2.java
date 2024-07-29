import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        // 동전의 종류
        // dp[k] 에서 k 는 동전의 가치 dp[k] = k원을 만드는 최소값
        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 1; i <= k ; i++) {
            dp[i] = 100001;
        }

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
            // 해당 coin[i] 배열에 존재하는 dp[coin[i]] 값은 1로 고정되어있음
            if (coin[i] <= k)
                dp[coin[i]] = 1;
        }

        for (int i = 1; i <= k ; i++) {
            for (int j = 0; j < n; j++) {
                // {i}값이 동전의 개수를 알고 있을떄
                // min(이미 만든것, 새롭게 만든것)
                // 3원과 10원이 있고 5원을 만드는 최소 개수가 2개임을 알고 있을때
                // 3, 5, 10 원이 존재하며 k 값은 100으로 고정

                if(i + coin[j] <= k){
                    // dp[i] 값이 존재한다면
                    // dp[i + coin[j]] = dp[i] + 1 값이다.
                    dp[i + coin[j]] = Math.min(dp[i + coin[j]], dp[i] + 1);
                }
            }
        }
        if (dp[k] == 100001){
            System.out.println(-1);
        }else{
            System.out.println(dp[k]);
        }

    }

}
