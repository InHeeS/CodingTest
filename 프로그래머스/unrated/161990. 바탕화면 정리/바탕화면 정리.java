import java.util.Arrays;
class Solution {
    public int[] solution(String[] wallpaper) {
        // 최소 거리
        // 드래그 거리 abs(rdx - lux) + abs(rdy - luy)
        // 직사각형 내부 모두 선택된다.
        // return 시작점, 끝점
        //wallpaper[i][j]는 바탕화면에서 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
        //바탕화면에는 적어도 하나의 파일이 있습니다.
        // ........ ....#.... -> # = (1,4)
        int minRow = 51, maxRow =0;
        int minCol = 52, maxCol =0;
        for(int i=0;i< wallpaper.length;i++){
            for(int j =0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minRow = Math.min(minRow, j);
                    minCol = Math.min(minCol, i);

                    maxRow = Math.max(maxRow, j + 1);
                    maxCol = Math.max(maxCol, i + 1);
                }
            }
        }

        return new int[]{minCol, minRow, maxCol, maxRow};
    }
}