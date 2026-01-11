class Solution {
    public static int[] solution(int n , int m) {
        // 유클리드 호제법
        // n, m = (최대공약수gcd, 최소공배수lcm) => n < m 일때 m % n, n
        // n, m 의 최대공약수는 m % n, n 의 최대공약수와 같다.
        // 최소공배수 = 주 자연수의 곱 / 최대공약수
        int[] ans = {};
        if(n > m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        int gcd = gcd(n, m);
        int lcm = lcm(n, m);

        return new int[]{gcd, lcm};
    }

    private static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

    private static int gcd(int n, int m) {
        if(n == 0){
            return m;
        }
        return gcd(m % n, n);
    }
}