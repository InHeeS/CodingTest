import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        // 우선순위큐를 활용하면 매번 가장 작은 원소를 o(long n) 에 꺼낼 수 있음
        // (scovile.length) -> n * log(n)
        // default = aes
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.offer(s);
        }

        int mixCount = 0;
        while(!heap.isEmpty()){
            if (heap.peek() >= K) {
                return mixCount;
            }

            if (heap.size() < 2){
                return -1;
            }
            
            int least = heap.poll();
            int second = heap.poll();
            int newScovile = least + (second * 2);
            
            heap.offer(newScovile);
            mixCount++;
        }
        
        return -1;
    }
}