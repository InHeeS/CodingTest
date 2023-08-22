import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String[] babbling) {
//        List<String> list = new ArrayList<>();
//        list.add("aya");
//        list.add("ye");
//        list.add("woo");
//        list.add("ma");
        int cnt =0;
        // 해당하는 글자가 있다면 ->없애고 비어있는지 확인
        for(int i=0 ; i< babbling.length; i++){
            System.out.println(babbling[i]);
            babbling[i] =  babbling[i].replaceAll("ayaaya|yeye|woowoo|mama", " ");
            System.out.println(babbling[i]);
            babbling[i] =  babbling[i].replaceAll("aya|ye|woo|ma", "");
            System.out.println(babbling[i]);
            if(babbling[i].isEmpty())cnt++;
            System.out.println("---------------------");
        }
        return cnt;
    }
}