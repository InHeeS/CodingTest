import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    // 시작 노드에서 4방향 탐색을 진행, 중복되는 탐새 제거
    // 작은 사이클이 큰 사이클안에 포함될 수 없다.
    private static final int DIR_NUM = 4, MAX_SIZE = 500;
    private static int r ,c;


    // 완전 탐색, 왼쪽위 기준 북동남서, dx = 상하, dy = 우좌
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0, 1,0, -1};
    private static boolean[][][] visited = new boolean[MAX_SIZE][MAX_SIZE][DIR_NUM];
    private static int[][] value = new int[MAX_SIZE][MAX_SIZE];

    private static List<Integer> result = new ArrayList<>();

    public static int[] solution(String[] grid) {
        initialize(grid);
        move();
        int[] answer = result.stream()
            .mapToInt(i -> i)
            .toArray();
        Arrays.sort(answer);
        return answer;

    }

    private static void move() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < DIR_NUM; k++) {
                    if (!visited[i][j][k]) {
                        result.add(moveRoute(i,j,k));
                    }
                }
            }
        }
    }

    private static int moveRoute(int x, int y, int d) {
        int cnt =0;
        int nowX =x;
        int nowY = y;
        int nowD = d;
        while(true){

            if (visited[nowX][nowY][nowD])
                break;

            cnt++;
            visited[nowX][nowY][nowD] = true;

            // r = 행의 개수(세로) , c = 한 행의 길이(가로)
            int nx = (nowX + dx[nowD] + r) % r;
            int ny = (nowY + dy[nowD] + c) % c;

            // DIR_NUM = 동서남북(4가지) -> %에 영향을줄뿐 나머지는 영향 미치지 않음
            int nd = (nowD + value[nx][ny] + DIR_NUM) % DIR_NUM;

            nowX = nx;
            nowY = ny;
            nowD = nd;

        }

        return cnt;
    }

    private static void initialize(String[] grid) {
        r = grid.length;
        c = grid[0].length();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i].charAt(j) == 'S') {
                    value[i][j] = 0;
                } else if (grid[i].charAt(j) == 'L') {
                    value[i][j] = 1;
                } else
                    value[i][j] = -1; //R
            }
        }
    }
}