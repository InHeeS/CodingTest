
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] a;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 1; i <= N ; i++) {
            Collections.sort(a[i]);
        }

        int ans = 0;
        for (int color = 1; color < N + 1; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left_distance = toLeft(color, i);
                int right_distance = toRight(color, i);
                ans += Math.min(left_distance, right_distance);
            }
        }
        System.out.println(ans);
    }

    private static int toRight(int color, int idx) {
        if (idx + 1 == a[color].size()){
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    private static int toLeft(int color, int idx) {
        if (idx == 0){
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new ArrayList[N + 1];

        for (int color = 1; color <= N ; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N ; i++) {
            int coord, color;
            coord = sc.nextInt();
            color = sc.nextInt();
            a[color].add(coord);
        }
    }

}
