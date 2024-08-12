
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // min heap 으로 구현하여
        // 힙 안에 n 개의 데이터만 남기고
        // 힙의 루트에 해당한는 수가 n번째 큰수 이다.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }
        // n개의 큰수를 님기게 되면 루트 노드에 있는수가
        // n번째로 큰수 

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(sc.nextInt());
                pq.poll();
            }
        }
        System.out.println(pq.poll());
    }

}
