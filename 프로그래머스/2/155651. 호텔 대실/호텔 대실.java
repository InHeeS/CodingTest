import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static int solution(String[][] book_time) {
        Arrays.sort(book_time, new Comparator<String[]>() {
            // 에약 시간 오름차순 정렬
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                else
                    // 시작 시간이 같지 않다면 빨리 끝나는 시간으로 정렬
                    return o1[0].compareTo(o2[0]);
            }
        });

        int[][] time =new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            int start_time = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":", ""));

            end_time += 10;
            if(end_time % 100 >= 60){
                end_time += 40;
            }
            time[i][0] = start_time;
            time[i][1] = end_time;
        }

        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < time.length; i++) {
            Collections.sort(rooms);
            boolean isAdd = false;

            for (int j = 0; j < rooms.size(); j++) {
                if (time[i][0] >= rooms.get(j)) {
                    // 값 변경
                    // 시작 시간과 룸의 끝시간 비교
                    rooms.set(j, time[i][1]);
                    isAdd = true;
                    break;
                }
            }

            if(!isAdd){
                rooms.add(time[i][1]);
            }
        }
        return rooms.size();
    }
      
}