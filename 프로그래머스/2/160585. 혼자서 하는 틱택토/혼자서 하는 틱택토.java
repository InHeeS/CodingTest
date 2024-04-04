class Solution {
    public static int solution(String[] board) {
        int answer = -1;
        String[][] map = new String[3][3];
        int o_cnt = 0, x_cnt = 0;

        for (int i = 0; i < 3; i++) {
            String[] str = board[i].split("");
            for (int j = 0; j < 3; j++) {
                map[i][j] = str[j];

                if (str[j].equals("O")) {
                    o_cnt++;
                }
                if (str[j].equals("X")) {
                    x_cnt++;
                }
            }
        }
        //기본적인 규칙 위반
        if(x_cnt > o_cnt || o_cnt - x_cnt > 1){
            return 0;
        }
        boolean o_check = check("O", map);
        boolean x_check = check("X", map);

        //게임이 종료되었을때 잘못된 경우
        if (o_check && (x_cnt + 1) != o_cnt) {
            return 0;
        }
        if (x_check && x_cnt != o_cnt)
            return 0;

        return 1;
    }

    private static boolean check(String target, String[][] map) {
        //가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0].equals(target) && map[i][1].equals(target)
                && map[i][2].equals(target))
                return true;
        }

        //세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i].equals(target) && map[1][i].equals(target)
                && map[2][i].equals(target))
                return true;
        }

        //대각선
        if (map[0][0].equals(target) && map[1][1].equals(target) && map[2][2].equals(target)) {
            return true;
        }

        if (map[2][0].equals(target) && map[1][1].equals(target) && map[0][2].equals(target)) {
            return true;
        }

        return false;
    }
}