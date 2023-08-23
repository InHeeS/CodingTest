import java.util.ArrayList;
import java.util.List;
class Solution {
    public String solution(String s, String skip, int index) {
        List<String> list = new ArrayList<>();
        //skip 안의 알페벳 제거
        for(int i='a'; i<='z'; i++)
            list.add(String.valueOf((char)i));

        list.removeIf(s1 -> skip.contains(s1));
        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");
        int idx = 0;
        for(int i=0 ; i<str.length;i++){
            for(int j=0; j<list.size();j++) {
                if(str[i].equals(list.get(j)))
                    idx = j + index;
            }
            sb.append(list.get(idx % list.size()));
        }
        return sb.toString();
    }
}