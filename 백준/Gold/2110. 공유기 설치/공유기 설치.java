import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, C;
    static int[] A;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        Arrays.sort(A, 1, N + 1);

        int L = 1, R = 1000000000, ans = 0;
        while(L <= R){
            int mid = (L + R) / 2;
            if (determination(mid)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean determination(int D) {
        // D 만큼의 거리 차이를 둔다면 C 개 만큼의 공유기를 설치할 수 있는가?

        // 제일 왼쪽 집부터 가능한 많이 설치해보자!
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C 를 비교하자.
        int cnt = 1, last = A[1];
        for (int i = 2; i <= N ; i++) {
            // 이번에 A[i] 에설치가 가능한가?
            if (A[i] - last >= D){
                cnt++;
                last = A[i];
            }
        }
        return cnt >= C;
    }

    private static void input() {
        N = sc.nextInt();
        C = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }



}
