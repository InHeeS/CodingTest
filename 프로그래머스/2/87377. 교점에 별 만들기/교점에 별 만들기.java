
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Coordinate{
    long x;
    long y;

    public Coordinate(long x, long y) {
        this.x = x;
        this.y = y;
    }

    void setX(long x) {
        this.x = x;
    }

    void setY(long y) {
        this.y = y;
    }
}

class Solution {
    
public static String[] solution(int[][] line) {
        // Ax + By + C = 0
        List<Coordinate> cList = new ArrayList<>();
        for (int i = 0; i < line.length -1; i++) {
            for (int j = i +1; j < line.length; j++) {

                long a = line[i][0], b = line[i][1], e = line[i][2],
                    c = line[j][0], d = line[j][1], f = line[j][2];

                if (a * d - b * c != 0) {
                    double x = (double) (b * f - e * d) / (a * d - b * c);
                    double y = (double) (e * c - a * f) / (a * d - b * c);
                    if (x % 1 == 0 && y % 1 == 0) {
                        cList.add(new Coordinate((long)x , (long) y));
                    }
                }
            }
        }

        Coordinate min = new Coordinate(Long.MAX_VALUE, Long.MAX_VALUE);
        Coordinate max = new Coordinate(Long.MIN_VALUE, Long.MIN_VALUE);

        for (Coordinate c : cList) {
            long cx = c.x;
            long cy = c.y;

            if (cx < min.x) {
                min.setX(cx);
            }
            if(cy < min.y){
                min.setY(cy);
            }

            if(cx > max.x){
                max.setX(cx);
            }

            if(cy > max.y){
                max.setY(cy);
            }
        }

        // 격자판 크기 산출
        int width = (int)(max.x - min.x + 1);
        int height = (int)(max.y - min.y + 1);

        char[][] arr= new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = '.';
            }
        }

        // 교점 찍기
        // point! 모든 별을 포함하는 최소한의 크기
        for (Coordinate c : cList) {
            arr[(int)(max.y - c.y)][(int)(c.x - min.x)] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;

    }
}