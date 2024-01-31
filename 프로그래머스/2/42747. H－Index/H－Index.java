import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        int h =0;
        Arrays.sort(citations);

        for (int i = 0; i < len; i++) {
            h = Math.max(h, Math.min(citations[i], len - i));
        }
        return h;
    }
}