class Solution {
    public static int solution(String t, String p) {
        // t의 문자열을 p의 길이만큼 쪼개서 비교하기
        // 비교할때 String to Integer
        int lowCnt = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            if(p.compareTo((t.substring(i, i + p.length()))) >= 0){
                lowCnt++;
            }
        }
        return lowCnt;
    }
}