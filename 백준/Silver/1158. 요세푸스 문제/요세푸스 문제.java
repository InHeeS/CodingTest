
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc. nextInt();

        List<Integer> survivors = new ArrayList<>();
        for (int i = 1; i <= N ; i++) {
            survivors.add(i);
        }

        int currentIndex = 0;
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            currentIndex = (currentIndex + K - 1) % survivors.size();
            ans[i] = survivors.remove(currentIndex);
        }

            System.out.print("<" + Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "))  + ">");
    }

}
