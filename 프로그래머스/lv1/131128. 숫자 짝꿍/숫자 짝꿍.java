import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String X, String Y) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> xmap = new HashMap<>();
        Map<String, Integer> ymap = new HashMap<>();

        for(String key : X.split(""))
            xmap.put(key, xmap.getOrDefault(key, 0) + 1);
        for(String key : Y.split(""))
            ymap.put(key, ymap.getOrDefault(key, 0) + 1);

        for(String key : xmap.keySet()){
            if(!ymap.containsKey(key))
                continue;;

            int len = Math.min(xmap.get(key), ymap.get(key));
            for(int i=0; i<len;i++)
                list.add(key);
        }

        list.sort(Comparator.reverseOrder());
        if(list.isEmpty())
            return "-1";
        if(list.get(0).equals("0"))
            return "0";
        StringBuilder sb =new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}