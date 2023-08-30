import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 동일한 유저(A) 가 B 에게 2번이상의 신고 중복 허용 x

        // 신고 받은 유저 : 신고 한 유저
        Map<String, HashSet<String>> map = new HashMap<>();
        // 신고 받은 유저 : 받은 통보 수
        Map<String, Integer> mail = new HashMap<>();

        for(int i=0; i< id_list.length; i++){
            HashSet<String> tmp = new HashSet<>();

            map.put(id_list[i], tmp); // 중복 x
            mail.put(id_list[i], 0);
        }

        for(int i=0; i<report.length;i++){
            String[] str = report[i].split(" ");
            map.get(str[1]).add(str[0]);
        }

        for(String s : map.keySet()){
            HashSet<String> tmp = map.get(s);
            if(tmp.size() >= k){
                for(String str : tmp){
                    mail.put(str,mail.get(str) + 1);
                }
            }
        }
        int[] rs = new int[id_list.length];
        for(int i=0; i<id_list.length;i++)
            rs[i] = mail.get(id_list[i]);
            
        return rs;
    }
}