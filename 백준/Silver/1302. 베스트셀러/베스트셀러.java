
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = sc.next();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCnt = 0;
        for (Map.Entry<String, Integer> title : map.entrySet()) {
            String titleName = title.getKey();
            int cnt = title.getValue();

            if (cnt > maxCnt ||
                (cnt == maxCnt && titleName.compareTo(maxTitle) < 0)){
                maxTitle = titleName;
                maxCnt = cnt;
            }
        }
        System.out.println(maxTitle);
    }

}
