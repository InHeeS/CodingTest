import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // n ^ m 개의 수열을 탐색해야한다.

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] selected, nums, used;

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    private static void rec_func(int k) {
        if (k == m + 1){
            for (int i = 1; i < m + 1; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else{
            int last_cand = 0;
            for (int cand = 1; cand <= n; cand++) {
                if (used[cand] == 1) continue;
                if (nums[cand] == last_cand) continue;

                last_cand = nums[cand];

                selected[k] = nums[cand];
                used[cand] = 1;

                rec_func(k + 1);

                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m + 1];
        nums = new int[n + 1];
        used = new int[n +1];
        for (int i = 1; i <= n ; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums, 1, n + 1);
    }

}

