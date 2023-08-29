import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] park, String[] routes) {
//start 위치 찾기, return new int[]{?, ?}
        //Map<String, int[]> map = new HashMap<>();, int[] dy_dx = map.get(key);
        // 시작점 갱신해주고 , 조건에 맞지 않으면 갱신하지않고 다음 명령어로 이동

        Map<Character, int[]> map = new HashMap<>();
        int[] start = getStart(park);

        //이동 방향
        map.put('E', new int[]{0,1});
        map.put('W', new int[]{0,-1});
        map.put('S', new int[]{1,0});
        map.put('N', new int[]{-1,0});

        for(int i=0; i<routes.length;i++){

            //dy : 가로위치 , dx : 세로 위치
            int [] dydx = map.get(routes[i].charAt(0));
            int dy = dydx[1], dx = dydx[0];
            int cdy = start[1], cdx = start[0];
            boolean flag = true;

            for(int j=0; j < (routes[i].charAt(2) - '0'); j++){
                cdy += dy;
                cdx += dx;

                //예외 조건 파악
                if(cdy < 0 || cdx < 0 || cdy > park[0].length() -1 || cdx > park.length -1
                || park[cdx].charAt(cdy) == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                start[0] = cdx;
                start[1] = cdy;
            }
        }
        return start;
    }

    private static int[] getStart(String[] park) {

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char loc = park[i].charAt(j);
                if (loc == 'S')
                    return new int[]{i, j};
            }
        }
        return new int[]{0,0};
    }
}