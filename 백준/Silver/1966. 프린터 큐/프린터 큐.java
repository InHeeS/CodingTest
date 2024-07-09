
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static class Job{
        int index;
        int priority;

        public Job(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<Job> q = new LinkedList<>();
            Integer[] prioritySequence = new Integer[N];
            for (int i = 0; i < N; i++) {
                prioritySequence[i] = sc.nextInt();
                q.offer(new Job(i, prioritySequence[i]));
            }

            Arrays.sort(prioritySequence, Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                while(q.peek().priority != prioritySequence[i]) {
                    q.offer(q.poll());
                }
                if (q.peek().index == M){
                    System.out.println(i + 1);
                    break;
                }
                q.poll();
            }


        }
    }

}
