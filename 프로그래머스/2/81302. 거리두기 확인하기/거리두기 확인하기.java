
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            boolean check = true;
            for (int j = 0; j < 5 && check; j++) {
                for (int k = 0; k < 5 && check; k++) {
                    if (place[j].charAt(k) == 'P'){
                        if (!bfs(j,k,place)){
                            check = false;
                        }
                    }
                }
            }
            answer[i] = check ? 1 : 0;
        }
        return answer;
    }

    private static boolean bfs(int x, int y, String[] place) {
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx==x && ny==y)){
                    // 출발점 제외
                    continue;
                }
                int distance = Math.abs(nx - x) + Math.abs(ny - y); // 맨해튼 거리
                if(place[nx].charAt(ny) == 'P' && distance <= 2){
                    return false;
                } else if(place[nx].charAt(ny) == 'O' && distance < 2){
                    // 다음 탐색시 맨해튼 거리가 1증가하므로 d < 2 에서만 탐색 진행
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        return true;
    }
}