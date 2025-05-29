import java.util.ArrayDeque;
import java.util.Queue;


class Solution {
    
        private static final int[][] DIRS = {
        // 북동남서
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    /**
     * bfs solution
     * 순차적 방문으로 인한 최소값 처음으로 갱신 후 dist[nc][nr] != 0 성립
     */
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        dist[0][0] = 1;
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == n -1 && c == m -1){
                return dist[r][c];
            }

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && maps[nr][nc] == 1 && dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}