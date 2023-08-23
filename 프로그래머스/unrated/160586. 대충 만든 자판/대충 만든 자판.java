import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map =  new HashMap<>();

        // 각 문자열에서 a~z 까지 최소값만 넣어주기
        for(int i = 'A'; i <= 'Z'; i++){
            int min = Integer.MAX_VALUE;
            for (String s : keymap) {
                int idx = find(i, s);
                if (idx < min && idx != -1) min = idx;
            }
            if(min != Integer.MAX_VALUE)
                map.put((char)i, min);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (String target : targets) {
            int sum = 0;
            for (int j = 0; j < target.length(); j++) {
                if (map.containsKey(target.charAt(j)))
                    sum += map.get(target.charAt(j));
                else {
                    sum = -1;
                    break;
                }
            }
            list.add(sum);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
        public static int find(int idx, String s){

        for(int i=0 ;i< s.length();i++){
            if(s.charAt(i) == (char)idx)
                return i+1;
        }
        return -1;
    }
    
}