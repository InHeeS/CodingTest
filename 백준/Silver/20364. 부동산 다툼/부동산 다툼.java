import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        while(Q-- > 0){
            int x = sc.nextInt(), res = 0;
            int y = x;
            while(x > 0){
                if (estate[x]) res = x;
                x >>= 1;
                // 0100, 0101 -> 0010 
                // 부모노드 부터 루트 노드까지 올라가면서 먼저 방문한 노드를 확인

            }
            estate[y] = true;
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n, Q;
    static boolean[] estate;

    private static void input() {
        n = sc.nextInt();
        Q = sc.nextInt();
        estate = new boolean[n + 1];
    }



}
