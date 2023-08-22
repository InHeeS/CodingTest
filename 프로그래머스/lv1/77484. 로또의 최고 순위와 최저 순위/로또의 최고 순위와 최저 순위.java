
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int win_cnt =0;
        int zero_cnt =0;

        for(int i=0; i< lottos.length; i++){
            if(lottos[i] == 0)
                zero_cnt++;
            list.add(lottos[i]);
            ans.add(win_nums[i]);
        }
        for (int lotto : lottos) {
            if (ans.contains(lotto))
                win_cnt++;
        }
        System.out.println(win_cnt);
        System.out.println(zero_cnt);
        int[] rs = new int[2];
        // 0, 1, 2, 3, 4, 5, 6
        // 6  6  5  4  3  2  1
        if(win_cnt == (win_cnt + zero_cnt)) {
            if(win_cnt <= 1)
                rs[0] = rs[1] = 6;
            else
                rs[0] = rs[1] = 7 - win_cnt;

        }
        else {
            if(win_cnt <= 1){
                rs[0] = 7-(win_cnt + zero_cnt);
                rs[1] = 6;
            }else{
                rs[0] = 7-(win_cnt + zero_cnt);
                rs[1] = 7- win_cnt;
            }
        }
        return rs;
    }
}