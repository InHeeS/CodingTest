class Solution {
    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        int networkCount = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited, n);
                networkCount++;
            }
        }

        return networkCount;
    }

    private static void dfs(int node, int[][] computers, boolean[] visited, int n) {
        visited[node] = true;
        for (int next = 0; next < n; next++) {
            if (computers[node][next] == 1 && !visited[next]) {
                dfs(next, computers, visited, n);
            }
        }
    }
}