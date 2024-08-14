import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * DAG : 방향이 있고, 사이클이 없는 그래프
         * 진입방법
         * 진입 차수가 0 인 정점 선택
         * 선택된 정점을 위상 정렬된 대상으로 출력
         * 해당 정점과 연결된 간선을 제거(진입 차수를 감소)
         * 모든 노드를 다 정렬할 때 까지 1 ~ 3 번을 반복
         */

        Scanner sc  = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        List<Integer>[] list = new List[n + 1];
        int[] indegree = new int[n + 1];
        int[] check = new int[n +1];

        for (int i = 0; i < n +1; i++) {
            list[i] = new ArrayList<>();

        }

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dist = sc.nextInt();
            list[src].add(dist);
            // 방향 src -> dist
            indegree[dist]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <n +1; i++) {
            if (indegree[i] == 0 )q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            check[now] = 1;
            System.out.print(now + " ");
            for (int next : list[now]) {
                if (check[next] == 1) continue;
                indegree[next]--;
                if (indegree[next] == 0)
                    q.add(next);
            }
        }
    }

}
