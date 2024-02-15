import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
class Solution {
    public static int[] solution(int[] fees, String[] records) {
        //번호, 시간
        Map<String, Integer> parking = new HashMap<>();
        // 번호, 누적 시간 (차량 번호 기준으로 오름차순 정렬) -
        Map<String, Integer> costs = new TreeMap<>();

        for (String r : records) {
            String[] record = r.split(" ");
            int time = getMin(record[0]); //출차 시간
            String carNum = record[1]; // 차량 번호
            String io = record[2]; // in/out

            if(io.equals("IN")){
                parking.put(carNum, time);
            }
            if(io.equals("OUT")){
                if(!costs.containsKey(carNum)){
                    costs.put(carNum, time - parking.get(carNum));
                }else{
                    costs.put(carNum, costs.get(carNum) + time - parking.get(carNum));
                }
                parking.remove(carNum);
            }
        }
        // 아직 출차하지 않은 차 계산
        if(!parking.isEmpty()){
            for (String carNum : parking.keySet()) {
                Integer cost = costs.get(carNum);
                cost = (cost == null) ? 0 : cost;
                costs.put(carNum, cost + (23 * 60 + 59) - parking.get(carNum));
            }
        }

        List<Integer> answer = new ArrayList<>(costs.size());
        for (Integer c : costs.values()) {
            int basicTime = fees[0];
            int basicCharge = fees[1];
            int unitTime = fees[2];
            int unitCharge = fees[3];

            if(c <= basicTime){
                answer.add(basicCharge);
            }else {
                answer.add((int)(basicCharge + Math.ceil((double)(c - basicTime) / unitTime) * unitCharge));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

}