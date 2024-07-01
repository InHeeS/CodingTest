
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] userAmounts = new int[N];
        for (int i = 0; i < N; i++) {
            userAmounts[i] = sc.nextInt();
        }

        int l = 1, r = N * 10000, ans = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if (isPossible(userAmounts, m, M)){
                r = m - 1;
                ans = m;
            }else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossible(int[] userAmounts, int drawAmount, int maxDrawCount) {

        int drawCount = 1;
        int currentAmount = drawAmount;
        for (int userAmount : userAmounts) {
            if (userAmount > drawAmount) return false;
            if (userAmount > currentAmount){
                if (drawCount == maxDrawCount) return false;
                drawCount++;
                currentAmount = drawAmount;
            }
            currentAmount -= userAmount;
        }
        return true;
    }

}
