
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // LinkedHashMap : 삽입 순서를 유지하는 HashMap
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int message = sc.nextInt();
            map.put(message, map.getOrDefault(message, 0 ) + 1);;
        }

        Integer[] frequencies = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(frequencies, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int frequency : frequencies) {
            int count = map.get(frequency);
            while (count-- > 0){
                System.out.print(frequency + " ");
            }
        }
    }

}
