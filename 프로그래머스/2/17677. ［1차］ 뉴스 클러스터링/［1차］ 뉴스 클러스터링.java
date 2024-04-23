import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();

        createMultiSet(str1, list1);
        createMultiSet(str2, list2);

        Collections.sort(list1);
        Collections.sort(list2);

        // intersection
        for (String s : list1) {
            if (list2.remove(s)) {
                inter.add(s);
            }
            union.add(s);
        }

        // union
        for (String s : list2) {
            union.add(s);
        }

        // 자카드 유사도 구하기
        double j1 = inter.size();
        double j2 = union.size();

        double jakard = 0;

        if (union.size() == 0) {
            jakard = 1;
        }else
            jakard = (double) inter.size() / (double) union.size();
        return (int) (jakard * 65536);

    }

    private static void createMultiSet(String str, List<String> list) {
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);

            // 문자만 가진 경우에 list1 에 추가
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String letters = Character.toString(c1) + Character.toString(c2);
                list.add(letters);
            }

        }
    }
}