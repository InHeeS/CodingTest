import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    static class Process{
        int index;
        int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Deque<Process> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        for (int i = 0; i < priorities.length; i++) {
            // 주어진 큐대로 -> addLast()
            queue.addLast(new Process(i, priorities[i]));
            maxHeap.add(priorities[i]);
    }

        int executeCount = 0;
        while(!queue.isEmpty()){
            Process cur = queue.removeFirst();
            if (cur.priority == maxHeap.peek()){
                executeCount++;
                maxHeap.poll();
                if (cur.index == location){
                    return executeCount;
                }
            }else{
                queue.addLast(cur);
            }
        }
        return executeCount;
    }
}