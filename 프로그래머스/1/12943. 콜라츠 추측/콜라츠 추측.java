class Solution {
    public static int solution(int num) {
        long n = num;
        int cnt = 0;
        if (n == 1){
            return 0;
        }

        while (true) {
            if(n % 2 == 0) {
                n /= 2;
            }else {
                n = n * 3 + 1;
            }

            cnt++;
            if(cnt == 500){
                return -1;
            }
            if(n == 1){
                return cnt;
            }
        }
    }
}