
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int T = sc.nextInt();
        while(T-- > 0) {
            input();
            pro();
        }
    }

    private static void pro() {
        int x = sc.nextInt(), y = sc.nextInt();

        // x 에서 루트노드 까지 체크
        while(x > 0){
            check[x] = 1;
            x = par[x];
        }
        while(y > 0 && check[y] == 0){
            y = par[y];
        }

        System.out.println(y);
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] par, check;


    private static void input() {
        n = sc.nextInt();
        par = new int[n + 1];
        check = new int[n + 1];
        for (int i = 1; i < n ; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            par[v] = u; // 해당 v 정점의 부모노드의 값
        }
    }

}
