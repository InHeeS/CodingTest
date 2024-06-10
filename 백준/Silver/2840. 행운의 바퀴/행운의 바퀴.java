
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int curIndex = 0;
        while (K-- > 0) {
            // N is 바퀴의 칸수 ex) N = 3 -> array.length = 2
            int step = sc.nextInt();
            char nextAlphabet = sc.next().charAt(0);
            int nextIndex = ((curIndex - step) % N + N) % N;

            if (wheel[nextIndex] == '?'){
                 wheel[nextIndex] = nextAlphabet;
            }else if (wheel[nextIndex] != nextAlphabet){
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?')continue;
            if (used[wheel[i] - 'A']){
                System.out.println("!");
                return;
            }
            used[wheel[i] - 'A'] = true;
        }

        for (int i = 0; i < N; i++) {
            // 마지막 부터 출력 -> 배열의 마지막 부터가 아니라 Index 의 위치
            System.out.print(wheel[(curIndex + i) % N]);
        }
        System.out.println();
    }



}
