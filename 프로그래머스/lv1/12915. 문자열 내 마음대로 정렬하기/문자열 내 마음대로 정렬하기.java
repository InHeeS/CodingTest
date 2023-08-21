import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();

        for(int i=0; i< strings.length ;i++){
            list.add(strings[i].charAt(n) + strings[i]);
        }
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        String[] rs = new String[list.size()];

        for(int i=0;i < list.size(); i++){
            rs[i] = list.get(i).substring(1);
        }
        return rs;
    }
}