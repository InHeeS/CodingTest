import java.util.Arrays;
class Solution {
    // 최대 공약수로 나눌 수 없다면 최대 공약수의 약수로도 나누어 지지 안흔ㄴ다.
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // N개의 최대 공약수 구하기
        for (int i = 1; i <arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }

        if(!isDivide(arrayB, gcdA)){
            answer = Math.max(answer, gcdA);
        }

        if(!isDivide(arrayA, gcdB)){
            answer = Math.max(answer, gcdB);
        }
        return answer;
    }

    private static boolean isDivide(int[] array, int gcd) {
        for (int i : array) {
            if(i % gcd == 0){
                return true;
            }
        }
        return false;
    }

    private static int gcd(int a, int b) {
        if(b == 0)return a;
        return gcd(b, a%b);
    }
}