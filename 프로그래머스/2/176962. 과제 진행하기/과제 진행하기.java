import java.util.PriorityQueue;
import java.util.Stack;
class Solution {
    static class Subject implements Comparable<Subject>{

        String name;
        int start, playtime;

        public Subject(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Subject o) {
            return this.start - o.start; // 시작시간 오름 차순
        }
    }

    // 그리디
    // 과제 시작 시간 기준 오름차순으로 우선순위 큐에 저장
    // stack 활용하여 중간에 멈춘 과제를 넣어야 한다.
    // 만약 과제를 멈추지 않고 끝낼 수 있다면,
    // 정답 배열에 그 과제 이름을 저장해주고 현재 시간을 갱신한다.
    // 현재 시각에 시작할 수 있는 새로운 과제가 있다면 과제 시작
    // 현재 시각에 새로 시작할 수 있는 과제가 없고, 멈춰둔 과제가 있다면 가장 최근 과제 시작
    // 멈춰둔 과제가 없고 일정 시간후에 시작할 과제가 있다면 그과제 시작 -> 현재 시각 갱신 주의
    // 위의 3가지 경우가 아니라면 모든 과제 완료
    public static String[] solution(String[][] plans) {

        String[] answer = {};
        answer = new String[plans.length];
        int idx = 0;
        PriorityQueue<Subject> q = new PriorityQueue<>(((o1, o2) -> (o1.start - o2.start)));

        for (String[] p : plans) {
            q.add(new Subject(p[0], convertTime(p[1]), Integer.parseInt(p[2])));
        }

        Subject s = q.poll();
        int now = s.start;

        Stack<Subject> stk = new Stack<>();
        while (true) {
            if (!q.isEmpty() && now + s.playtime > q.peek().start) {
                // 과제 중지
                stk.push(new Subject(s.name, s.start, s.playtime - (q.peek().start - now)));

                now = q.peek().start;

                s = q.poll(); // 새로운 과제 시작
            }else {
                // 과제 끝냄
                answer[idx++] = s.name;
                now += s.playtime;

                //새로 시작해야 하는 과제가 있다면 시작
                if (!q.isEmpty() && now == q.peek().start){
                    s= q.poll();
                } else if (!stk.isEmpty()) {
                    s = stk.pop();
                } else if (!q.isEmpty()) {
                    s = q.poll();
                    now = s.start;
                }
                else
                    break;
            }
        }

        return answer;
    }

    private static int convertTime(String time) {
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}