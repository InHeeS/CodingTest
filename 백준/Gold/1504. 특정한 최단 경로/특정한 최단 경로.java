import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        if (e == 0){
            System.out.println(-1);
            return;
        }
        List<Edge_2>[] graph = new List[n + 1];
        int[] cost = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            cost[i] = INF;
        }
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt(), d = sc.nextInt(), c = sc.nextInt();
            graph[s].add(new Edge_2(d, c));
            graph[d].add(new Edge_2(s, c));
        }
        int v1 = sc.nextInt(), v2 = sc.nextInt();
        int answer1 = dijkstra(graph, 1, v1) + dijkstra(graph, v1, v2) + dijkstra(graph, v2, n);
        int answer2 = dijkstra(graph, 1, v2) + dijkstra(graph, v2, v1) + dijkstra(graph, v1, n);

        int answer = Math.min(answer1, answer2);
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
    static int INF = 1000000000;
    static int dijkstra(List<Edge_2>[] graph, int start, int end){
        int[] cost = new int[graph.length];
        PriorityQueue<Edge_2> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        pq.offer(new Edge_2(start, 0));
        for (int i = 1; i < cost.length; i++) {
            cost[i] = INF;
            
        }
        cost[start] = 0;
        while(!pq.isEmpty()){
            Edge_2 now = pq.poll();
            if (cost[now.dist] < now.cost) continue;
            for(Edge_2 next : graph[now.dist]){
                if (cost[next.dist] > cost[now.dist] + next.cost){
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge_2(next.dist, cost[next.dist]));
                }
            }
        }
        return cost[end];
    }

}

class Edge_2{
    int dist, cost;

    public Edge_2(int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }
}
