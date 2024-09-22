
import java.util.Scanner;

public class Main {

    // system call 출력결과가 많으므로, 버퍼에 담았다가 한번에 출력
    static int[][] dp = new int[2001][2001];
    static int[] arr = new int[2001];
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < n +1; i++) {
            arr[i] = sc.nextInt();
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < m +1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(isPalindrome(s,e)).append("\n");
        }

        System.out.println(sb);
    }

    static int isPalindrome(int start, int end){
        if (start >= end)return 1;
        if (dp[start][end] != -1)
            return dp[start][end];

        if (arr[start] != arr[end])return dp[start][end] = 0;
        else dp[start][end] = isPalindrome(start + 1, end -1);
        return dp[start][end];
    }

}
