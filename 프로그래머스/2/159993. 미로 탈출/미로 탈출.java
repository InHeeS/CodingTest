import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
static final int[] dx = {-1, 0, 1 ,0}; // 행
    static final int[] dy = {0, -1 ,0, 1}; // 열

    static int ex;
    static int ey;

    // 최단거리 bfs
    public static int solution(String[] maps) {
        int sx = 0, sy = 0, lx = 0, ly = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                }else if(maps[i].charAt(j) == 'E'){
                    ex = i;
                    ey = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        // bfs 로 먼저 시작점 -> 레버의 최단 거리
        int step = bfs(new Node(sx, sy, 0), lx, ly, maps, visited, false);
        if(step == -1) return -1;

        // 시작점 -> 레버 -> 시작점 -> 도착점
        int sToe = bfs(new Node(sx, sy, step * 2), ex, ey, maps, visited,true);
        // 시작점 -> 레버 -> 도착점
        int lToe = bfs(new Node(lx, ly, step), ex, ey, maps, visited,true);

        if(lToe == -1)return sToe;
        else if (sToe == -1) return lToe;

        return Math.min(lToe, sToe);

    }

    private static int bfs(Node node, int ex, int ey, String[] maps, boolean[][] visited,
        boolean refresh) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        if(refresh){
            for (boolean[] booleans : visited) {
                // 방문 여부 초기화
                Arrays.fill(booleans, false);
            }
        }

        while(!queue.isEmpty()){
            Node n = queue.poll();

            if(n.x == ex && n.y == ey)return n.step; // 최단 거리 리턴
            if(visited[n.x][n.y])continue; // 방문한 경우 패스

            visited[n.x][n.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[nx].length()
                && !visited[nx][ny] && (maps[nx].charAt(ny) != 'X')){
                    queue.add(new Node(nx,ny, n.step + 1));
                }
            }
        }

        return -1;
    }

    static class Node{
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}