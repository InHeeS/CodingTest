class Solution {
    public static int solution(int n) {
        final int MOD = 1_000_000_007;
        if (n == 1){
            return 1;
        }
        
        long prev2 = 1; // dp[1] = 1
        long prev1 = 2; // dp[2] = 2
        long curr = prev1;

        for (int i = 3; i <= n ; i++) {
            curr = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return (int) curr;
    }
}