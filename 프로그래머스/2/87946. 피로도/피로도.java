class Solution {
    static int max = 0;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }
    // 깊이 우선 탐색으로 for 문 이후읭 max 값 비교 
    public static void dfs(int idx, int k, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(idx + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        max = Math.max(idx, max);
    }
}