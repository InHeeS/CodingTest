import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0 ,1};


    public static int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int[][] visited = new int[N][M];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = board[i];
            for (int j = 0; j < M; j++) {
                if(s.charAt(j) == 'R'){
                    q.add(new Point(i,j));
                    visited[i][j] = 1;
                    break;
                }
            }
        }
        int answer = -1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(board[cur.x].charAt(cur.y) == 'G') {
                answer = visited[cur.x][cur.y] - 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                while(true){
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M
                        && board[nx].charAt(ny) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    }else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if(visited[nx][ny] == 0){
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
        }
        return answer;
    }
}