class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String game = "";
        int gameCnt = t * m ;
        int num = 0;

        while (game.length() < gameCnt) {
            game += Integer.toString(num++, n);
        }

        for (int i = p - 1; i < gameCnt; i+=m) {
            answer += game.charAt(i);

        }

        return answer.toUpperCase();
    }
}