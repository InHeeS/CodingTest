import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 회의를 끝나는 시각을 기준으로 갖아
        // 먼저 끝나는 회의를 찾을 수 있는 최소힙을 구현
        // 하나의 종료 시간과 하나의 시작시간을 비교
        int n = sc.nextInt();
        List<Meeting> meeting = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            meeting.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        // 시작하는 시간이 같다면 끝나는 시간 오름차순
        // 다르다면 시작하는 시간 오름 차순
        // 회의실의 최소 개수의 최적화를 위해
        // 최대한 많은 회으를 처리하기 위해서 
        meeting.sort((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        });
        // 끝나는 시간 으로 오름차순
        // Class 이기 때문에 기준점을 정해주어야 한다.
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.end - o2.end;
        });

        int ans = 1;
        for (Meeting m : meeting) {
            if (pq.isEmpty()){
                pq.offer(m);
                continue;
            }
            // 들어온 회의의 시간보다 먼저 끝낼수 있다면
            // pq는 비워주기
            while (!pq.isEmpty() && pq.peek().end <= m.start)
                pq.poll();
            pq.offer(m);
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
    }

}
class Meeting{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
