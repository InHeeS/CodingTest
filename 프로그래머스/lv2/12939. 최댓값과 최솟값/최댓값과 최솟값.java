import java.util.Arrays;
import java.util.stream.Stream;
class Solution {
    public String solution(String s) {
        int[] arr = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int[] rs = new int[2];
        rs[0] = arr[0];
        rs[1] = arr[arr.length -1];

        StringBuilder sb = new StringBuilder();
        sb.append(rs[0]).append(" ");
        sb.append(rs[1]);

        return sb.toString();
    }
}