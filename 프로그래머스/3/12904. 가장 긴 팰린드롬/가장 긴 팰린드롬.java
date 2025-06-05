class Solution
{
    public int solution(String s) {
        int n = s.length();
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            // 홀수 길이 팰린드롬, i 자체를 중심
            int len1 = expandAroundCenter(s, i, i);
            // 짝수 길이 팰린드롬, i와 i+1을 중심
            int len2 = expandAroundCenter(s, i, i + 1);

            maxLen = Math.max(maxLen, Math.max(len1, len2));
        }
        return maxLen;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 팰린드롬의 길이 계산
    }
}