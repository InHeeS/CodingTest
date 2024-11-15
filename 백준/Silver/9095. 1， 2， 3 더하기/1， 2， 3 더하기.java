
import java.util.Scanner;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    
    static int[] Dy;
    
    
    public static void main(String[] args) {
        preprocess();
        pro();
    }
    
    // 전처리 과정 
    private static void preprocess() {
        Dy = new int[15];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        // 점화식은 그림을 그려가면서 파악해야 된다.
        for (int i = 4; i <= 11; i++) {
            Dy[i] = Dy[i -1] + Dy[i -2] + Dy[i -3];

        }
    }

    private static void pro() {
        int T = sc.nextInt();
        for (int tt = 1; tt <= T ; tt++) {
            int N = sc.nextInt();
            sb.append(Dy[N]).append("\n");
        }
        System.out.println(sb);
    }

}
