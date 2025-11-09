import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public static long solution(long n){
        Character[] array = String.valueOf(n).chars().mapToObj(c -> (char) c)
            .toArray(Character[]::new);
        Arrays.sort(array, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Character c : array) {
            sb.append(c);
        }
        return Long.parseLong(sb.toString());

    }
}