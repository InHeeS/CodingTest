import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
        String[] str = s.split("");
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        for(int i=0; i<s.length();i++){
            for(int j= 0 ; j<i; j++){
                if(str[i].equals(str[j])){
                    answer[i] = i - j;
                }
            }
        }
        return answer;
    }
}