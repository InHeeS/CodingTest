class Solution {
    public static int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);

        for (String s1 : s.split("0")) {
            if(s1.equals(""))continue;
            if(checkPrime(s1))
                answer++;
        }
        return answer;
    }

    public static boolean checkPrime(String num){
        long n = Long.parseLong(num);
        if(n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}