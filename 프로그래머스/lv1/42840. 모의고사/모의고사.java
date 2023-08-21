import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] answers) {
        int[] a= {1,2,3,4,5};
        int[] b= {2,1,2,3,2,4,2,5};
        int[] c= {3,3,1,1,2,2,4,4,5,5};
        int a_cnt =0, b_cnt =0, c_cnt =0;

        for(int i=0; i< answers.length;i++){
            if(a[i % 5] == answers[i])a_cnt++;
            if(b[i % 8] == answers[i])b_cnt++;
            if(c[i % 10] == answers[i])c_cnt++;
        }

        int _max = Math.max(a_cnt, Math.max(b_cnt , c_cnt));
        List<Integer> list = new ArrayList<>();
        if(_max == a_cnt)list.add(1);
        if(_max == b_cnt)list.add(2);
        if(_max == c_cnt)list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}