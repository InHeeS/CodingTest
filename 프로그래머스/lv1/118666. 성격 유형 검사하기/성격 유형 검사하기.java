import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //map 으로 key value 갱신
        // choices =  3 2 1 0 1 2 3
        Map<Character, Integer> map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4){
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + choices[i] -4);
            }else{
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0)  + 4 - choices[i]);
            }
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        if(map.get('T') > map.get('R'))
            sb.append('T');
        else
            sb.append('R');

        if(map.get('F') > map.get('C'))
            sb.append('F');
        else
            sb.append('C');

        if(map.get('M') > map.get('J'))
            sb.append('M');
        else
            sb.append('J');

        if(map.get('N') > map.get('A'))
            sb.append('N');
        else
            sb.append('A');

        return sb.toString();
    }
}