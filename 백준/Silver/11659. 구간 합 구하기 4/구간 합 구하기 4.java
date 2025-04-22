import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        solution();

    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[n+ 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[k] - prefixSum[j- 1]).append("\n");
        }

        System.out.println(sb);


    }
}
