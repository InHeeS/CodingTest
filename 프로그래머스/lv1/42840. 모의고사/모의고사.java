import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a= {1,2,3,4,5};
        int[] b= {2,1,2,3,2,4,2,5};
        int[] c= {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[3];

        for(int i=0; i< answers.length;i++){
            if(a[i % 5] == answers[i])cnt[0]++;
            if(b[i % 8] == answers[i])cnt[1]++;
            if(c[i % 10] == answers[i])cnt[2]++;
        }

        int _max = Math.max(cnt[0], Math.max(cnt[1] , cnt[2]));
        List<Integer> list = new ArrayList<>();
        for(int i=0; i< 3; i++){
            if(_max == cnt[i]) 
                list.add(i+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}