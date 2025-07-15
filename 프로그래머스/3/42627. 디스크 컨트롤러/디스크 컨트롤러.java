import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[][] jobs) {
        /**
         * 작업의 소요시간이 짧은 것,
         * 작업의 요청 시각이 빠른 것,
         * 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
         * [s, j] = 요청 시점, 작업 소요시간
         */

        // 정렬이 필요한 이유 : ??
        Arrays.sort(jobs, Comparator.comparingInt(n -> n[0]));

        // 작업 소요시간 - 요청 시점
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]){
                return o1[1] - o2[1];
                // return Integer.compare(o1[1] - o2[1]));
            }
            return o1[0] - o2[0];
        });

        int size = jobs.length;
        int currentTime = 0;
        long totalTurnAround = 0;
        int count = 0;
        int idx = 0;

//        pq.add(new int[]{jobs[0][0], jobs[0][1]});

        while(count < size){
            while(idx < size && jobs[idx][0] <= currentTime){
                pq.add(new int[]{jobs[idx][0], jobs[idx][1]});
                idx++;
            }

            if (!pq.isEmpty()){
                int[] job = pq.poll();
                int arrival = job[0];
                int duration = job[1];

                currentTime += duration;
                totalTurnAround += (currentTime - arrival);
                count++;
            }else{
                currentTime = jobs[idx][0];
            }
        }

        return (int)totalTurnAround / size;
    }

}