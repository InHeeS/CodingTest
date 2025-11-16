import java.util.Arrays;


class Solution {
    public static String solution(String s) {
        char[] charArray2 = s.toCharArray();
        Character[] charArray = new Character[charArray2.length];

        for (int i = 0; i < charArray2.length; i++) {
            charArray[i] = charArray2[i];
        }

        Arrays.sort(charArray, (c1, c2) -> {
            boolean c1Lower = Character.isLowerCase(c1);
            boolean c2Lower = Character.isLowerCase(c2);

            // 1. 둘 중 하나만 소문자라면 소문자가 먼저
            if (c1Lower && !c2Lower) return -1;   // c1 먼저
            if (!c1Lower && c2Lower) return 1;    // c2 먼저

           // 2. 둘 다 같은 범위라면 기존 문자 코드 기준 렬
            return Character.compare(c2, c1);
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : charArray) {
            sb.append(c);
        }

        return sb.toString();
    }
}