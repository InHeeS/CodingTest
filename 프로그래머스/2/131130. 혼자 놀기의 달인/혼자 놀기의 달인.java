import java.util.Collections;
import java.util.PriorityQueue;
class Solution {

    static PriorityQueue<Integer> queue;

    // 1번 그룹과 2번 그룹의 상자의 곱의 최대값
    // dfs
    public static int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        boolean[] visited = new boolean[n];

        // 상자 그룹의 개수를 저장
        queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(cards,i, visited, 0);
        }

        // queue 크기가 1이면 1번 상자 그룹밖에 없다는 의미
        if(queue.size() != 1){
            answer = queue.poll() * queue.poll();
        }

        return answer;
    }

    private static void dfs(int[] cards, int num, boolean[] visited, int cnt) {
        if(visited[num]){
            queue.add(cnt);
            return;
        }
        visited[num] = true;
        dfs(cards, cards[num] - 1, visited, cnt + 1);
    }
}