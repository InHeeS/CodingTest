import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        // 1 4 5 8 9
        int h = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            // papers = 인용횟수
            int papers = len - i;
            if (citations[i] >= papers){
                return papers;
            }
        }
        return 0;
    }

}