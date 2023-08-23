import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // terms -> map
        // 날짜 일수로 계산

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.valueOf(s[1]));
        }
        System.out.println(map);

        for(int i=0; i<privacies.length;i++){
            String[] p = privacies[i].split(" ");
            int days = getDays(p[0]);
            int todays = getDays(today);
            if(todays - days >= map.get(p[1]) * 28)
                list.add(i +1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
        private static int getDays(String date) {
        String[] s = date.split("\\.");
        int year= Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);

        return 12 * 28 * (year -1) + 28 * (month -1) + day;
    }
}