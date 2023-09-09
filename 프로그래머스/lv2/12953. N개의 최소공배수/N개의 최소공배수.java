class Solution {
    public static int solution(int[] arr) {

        if(arr.length == 1) return arr[0];

        int n = gcd(arr[0], arr[1]);
        int rs = arr[0] * arr[1] / n;

        if(arr.length > 2)  {
            for(int i=2 ; i< arr.length; i++){
                n = gcd(rs, arr[i]);
                rs = rs * arr[i] / n;
            }
        }
        return rs;
    }

    private static int gcd(int a, int b) {
        int mod = a % b;
        if(mod == 0) return b;
        else return gcd(b, mod);
    }
}