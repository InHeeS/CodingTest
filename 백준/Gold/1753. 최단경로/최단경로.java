import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] dist;
    static int n, m, k;
    static ArrayList<Edge>[] edges;

    private static void pro() {
        dijkstra(k);
        for (int i = 1; i <= n ; i++) {
            if (dist[i] == Integer.MAX_VALUE)sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        for (int i = 1; i <= n ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Info info = pq.poll();

            // 낡은 정보는 폐기
            if (dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }

        }
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        dist = new int[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m ; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }
    }


    private static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
