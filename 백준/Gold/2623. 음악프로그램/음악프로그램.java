import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 사이클이 생긴다면 불가능하다고 판단
        // 위상 정렬을 사용한다면 사이클이 발생하지 않는 경우가 맞다.
        // 정점이 n개 이며 check[] 에 모두 표시가 되었는지 검증
        // degree[] == 0 이라면 위상정렬에 추가해준다. <= point
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] list = new ArrayList[n +1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();

        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n + 1];
        int[] check = new int[n +1];
        for (int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            int front = sc.nextInt();
            for (int j = 2; j < cnt + 1; j++) {
                int back = sc.nextInt();
                list[front].add(back);
                indegree[back]++;
                front = back;

            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0)q.add(i);
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            check[now] = 1;
            answer.add(now);
            if (answer.size() > n){
                System.out.println(0);
                return;
            }
            for (int next : list[now]) {
                if (check[next] == 1)continue;
                indegree[next]--;
                if (indegree[next] == 0)q.offer(next);

            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (check[i] == 0){
                System.out.println(0);
                return;
            }
        }
        for (Integer ans : answer) {
            System.out.println(ans);
        }




    }

}
