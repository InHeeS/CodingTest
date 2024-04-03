import static java.lang.Math.*;

class Solution {
    public static int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;


        for (int i = 0; i < name.length(); i++) {
            answer += min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A' 가 끝나는 지점 찾기
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우이동 최소 횟수 구하기(순서대로 가기, 뒤로 돌아가기)
            move = min(move, (i * 2) + name.length() - next);
            move = min(move, (name.length() - next) * 2 + i);
        }
        return answer + move;
    }
}