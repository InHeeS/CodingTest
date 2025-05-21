import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


class Solution {
    public String[] solution(String[][] tickets) {
        // 출발 경로 -> 여러개의 도착 경로
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] t : tickets) {
            graph
                .computeIfAbsent(t[0], k -> new PriorityQueue<String>())
                .offer(t[1]);
        }
        List<String> route = new ArrayList<>();
        dfs("ICN", graph, route);

        Collections.reverse(route);
        return route.toArray(new String[0]); // 0 = route.size()
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> route) {
        PriorityQueue<String> pq = graph.get(airport);
        while(pq != null && !pq.isEmpty()){
            String next  = pq.poll();
            dfs(next, graph, route);
        }
        route.add(airport);
    }
}