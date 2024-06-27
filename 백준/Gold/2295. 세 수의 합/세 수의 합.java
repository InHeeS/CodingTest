
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr=  new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // a + b = x - c;
        // a + b 의 집합 생성

        int[] sums = new int[N * (N + 1) / 2];
        int sumsIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumsIndex++] = arr[i] + arr[j];

            }
        }

        Arrays.sort(sums);
        int ans = -1;
        // 모든 x-c 에 대해 a+ b집합에 존재하는지 확인한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (Arrays.binarySearch(sums, target) >= 0)
                    ans = Math.max(ans, arr[i]);
            }
        }
        System.out.println(ans);
    }

}
