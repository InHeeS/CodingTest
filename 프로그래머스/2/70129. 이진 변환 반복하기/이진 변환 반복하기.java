class Solution {
    public static int[] solution(String s) {
        int[] ans = {};
        int binaryCnt = 0;
        int delZeroCnt = 0;
        // toCharArray 로 0 의 개수 파악
        // 제거된 길이를 통해 이진변화

        while(true){
            if(s.equals("1")){
                return new int[]{binaryCnt, delZeroCnt};
            }
            int zeroCnt = 0;
            for (char c : s.toCharArray()) {
                if(c == '0'){
                    zeroCnt++;
                }
            }

            s = Integer.toBinaryString(s.length() - zeroCnt);
            binaryCnt++;
            delZeroCnt += zeroCnt;
        }
    }
}