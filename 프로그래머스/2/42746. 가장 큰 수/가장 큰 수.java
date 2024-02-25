import java.util.Arrays;
class Solution {
    public static String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        // 내림 차순
        Arrays.sort(str,((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
        // 0으로만 이루어진 배열
        if(str[0].equals("0")){
            return "0";
        }

        return String.join("", str);
    }
}