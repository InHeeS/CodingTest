import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // Collections.swap = O(n^2) => 시간초과
        // Map = O(n)
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i< players.length;i++){
            map.put(players[i], i);
        }
        for(int i=0; i< callings.length; i++){
            //0등은 불리지 않는다는 가정
            int rank = map.get(callings[i]);

            String front = players[rank -1];

            players[rank -1] = callings[i];
            players[rank] = front;

            map.put(callings[i], rank -1);
            map.put(front, rank);
        }
        return players;
    }
}