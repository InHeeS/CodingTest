
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // d[n] : n일동안 상담을 했을 때 최대 수익
        // 상담은 {i + t[i]} 일에 종료가 된다.
        // d[i + t[i]] = max(d[i + t[i], d[i] + p[i])
        // i + t[i] : i 번째 일을 하지 않고 여태까지 번 최대의 돈
        // 이는 i번째 상담을 했을 때와 하지 않았을 때 중 더 큰 값을 가지게 됩니다.
        // d[i] + p[i] : 일이 시작되는 시점까지 번돈 + i 번째 일을 하고 번돈
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];

        int[] d = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        for (int i = 1; i < n + 2; i++) {
            d[i] = Math.max(d[i -1], d[i]);
            if (i + t[i] > n +1)continue;
            d[i + t[i]] = Math.max(d[i + t[i]], p[i] + d[i]);

        }
        System.out.println(d[n + 1]);

    }

}
