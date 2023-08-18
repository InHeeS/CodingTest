import java.util.Arrays;
class Solution {
    public String solution(String s) {
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(char i : arr){
            sb.append(i);
        }
        return sb.reverse().toString();
    }
}