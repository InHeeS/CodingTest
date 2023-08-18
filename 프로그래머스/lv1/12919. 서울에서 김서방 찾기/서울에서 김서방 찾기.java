import java.util.Arrays;
class Solution {
    public String solution(String[] seoul) {
        int loc = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + loc + "에 있다";
    }
}