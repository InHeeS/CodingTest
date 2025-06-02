import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[][] jobs) {
        // 요청 시각 기준으로 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(n -> n[0]));

        // 현재 시간
        int time = 0;
        long totalTurnaround = 0;
        // 처리된 작업 개수
        int count = 0;
        // 정렬된 배열에서 대기 큐에 아직 추가하지 않은 작업의 인덱스
        int idx = 0;
        int n = jobs.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]){
                    return Integer.compare(a[1], b[1]); // 소유 시간 우선
                }
                return Integer.compare(a[0], b[0]); // 소요 시간이 같으면 요청 시각 순
            }
        );

        while(count < n){

            // 현재 시각까지 도착한 작업들을 대기 큐에 넣기
            while(idx < n && jobs[idx][0] <= time){
                pq.offer(new int[]{jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            // 대키 큐에 작업이 있다면 소요 시간이 가장 짧은 작업을 꺼내 처리 - priority queue
            if (!pq.isEmpty()){
                int[] job = pq.poll();
                int arrival = job[0];
                int duration = job[1];

                time += duration;
                totalTurnaround += (time - arrival);
                count++;
            }else{
                time = jobs[idx][0];
            }
        }

        return (int)(totalTurnaround / n);

    }

}