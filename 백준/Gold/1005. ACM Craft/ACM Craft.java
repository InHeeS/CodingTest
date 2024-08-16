import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // dp[next]: next번째 건물이 완성되는데 필요한 시간
    // dp[next] = max(dp[now]) + time[i]
    // next, now 는 위상정렬을 통해 구해야 한다.
    // dp 의 init = if (indegree[i] == 0) dp[i] = time[i]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] time = new int[n +1];
            int[] dp = new int[n +1];
            int[] indegree = new int[n + 1];
            int[][] adj = new int[n +1][n+ 1]; // n의 값이 크지 않키 떄문에 인접 행렬로 표현
            for (int j = 1; j < n + 1 ; j++) {
                time[j] = sc.nextInt();
            }
            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a][b] = 1;
                indegree[b]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int j = 1; j < n + 1; j++) {
                // 처음 정점
                if (indegree[j] == 0){
                    q.offer(j);
                    dp[j] = time[j];
                }
            }
            while(!q.isEmpty()){
                // now = indgree : 0
                int now = q.poll();
                for (int next = 1; next< n + 1; next++) {
                    if (adj[now][next] == 1){
                        // 위상정렬의 반복을 위해 next --
                        indegree[next]--;
                        // 경우의 수가 늘어났을때 dp[next] 값은 갱신되어 있을거임
                        dp[next] = Math.max(dp[next], dp[now] + time[next]);
                        if (indegree[next] == 0)q.offer(next);
                    }

                }
            }
            int w = sc.nextInt();
            System.out.println(dp[w]);
        }

    }

}
