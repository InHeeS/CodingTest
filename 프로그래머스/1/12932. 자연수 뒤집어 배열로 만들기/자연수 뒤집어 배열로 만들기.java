import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
class Solution {
    public static int[] solution(long n){
        char[] charArray = String.valueOf(n).toCharArray();

        return IntStream.range(0, charArray.length)
            .map(i -> charArray[charArray.length - 1 - i] - '0').toArray();
    }
}