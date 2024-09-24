
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        // 입력이 10만개라면 next int parsing 시 반복되는 시스템콜로 느려짐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(divide(1, n));

    }

    // O(log n )
    static int divide(int start, int end) {
        int mid = (start + end + 1) / 2;
        if (start == mid) {
            return start;
        }
        if (decision(mid)) {
            return divide(mid, end);
        } else {
            // [1, mid] 구간 만큼 만들어지지않으면
            return divide(start, mid - 1);
        }
    }

    static int[] check = new int[500001];

    static boolean decision(int length) {
        int pack = 0;
        int begin = 1;
        int end = 1;
        Arrays.fill(check, -1);
        while (end <= n) {
            // end 위치에 있는 카드가 중복
            if (check[arr[end]] >= begin) {
                begin = check[arr[end]] + 1;
            }

            check[arr[end]] = end;
            if (end - begin + 1 == length) {
                pack++;
                begin = end + 1;
            }
            if (pack == m) {
                return true;
            }
            end++;
        }
        // 카드팩이 m 개 만큼 만들어지지 않는다면
        return false;
    }
}
