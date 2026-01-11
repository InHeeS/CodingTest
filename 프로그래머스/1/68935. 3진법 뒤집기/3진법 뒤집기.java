class Solution {
    public static int solution(int n) {
        // Integer.toString(n, 3) api 도 존재함
        // Integer.parseInt(s, 3) api 도 존재함

        String ternary = toTernary(n);
        String reverseTernary = new StringBuilder(ternary).reverse().toString();
        int result = 0;
        for (int i = 0; i < reverseTernary.length(); i++) {
            int digit = reverseTernary.charAt(i) - '0';
            result = result * 3 + digit;
        }

        return result;
    }

    private static String toTernary(int n) {
        if(n < 3){
            return String.valueOf(n);
        }
        return toTernary(n / 3) + (n % 3);
    }
}