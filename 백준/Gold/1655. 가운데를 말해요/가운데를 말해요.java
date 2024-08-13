import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 최대 힙, 최소 힙을 모두 사용하여 중간값을 가져간다.
        // 두개의 힙에 수를 번갈아 넣는다. 최대힙 큐 - 최소힙 큐
        // 각 힙의 루트에서 수를 뽑은 뒤, 대소관계를 비교한다.
        // 오른쪽힙에 더 작은 값이 있다면 위치를 서로 바꾼다.
        // 즉 작은 값이 담기는것은 최대힙이다.

        int n = sc.nextInt();
        PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> {
          return o1 < o2 ? 1 : -1;
        });
        PriorityQueue<Integer> big = new PriorityQueue<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (small.size() == big.size()) small.offer(num);
            else
                big.offer(num);

            if (!small.isEmpty() && !big.isEmpty()){
                int s = small.peek();
                int b = big.peek();
                if (s > b){
                    small.poll();
                    big.poll();
                    small.offer(b);
                    big.offer(s);
                }
            }
            ans.append(small.peek()).append("\n");
        }
        System.out.println(ans);
    }

}
