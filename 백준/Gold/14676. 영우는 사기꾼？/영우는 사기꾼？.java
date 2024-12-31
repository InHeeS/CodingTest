import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        boolean abnormal = false;
        while (k-- > 0) {
            int t = sc.nextInt(), x = sc.nextInt();
            if (t == 1){

                // x의 선행 건물들이 모두 지어졌는지 확인
                if (satisfaction[x] < indeg[x])
                    abnormal = true;

                cnt[x]++;
                // x 가 처음 지어진 것이라면 x가 영향을 주는 건물들에 알려주기
                if (cnt[x] == 1){
                    for (int y : adj[x]) {
                        satisfaction[y]++;
                    }
                }
            }else{
                // x라는 건물이 한개 이상 주어졌는지 확인
                if (cnt[x] == 0){
                    abnormal = true;
                }
                cnt[x]--;
                if (cnt[x] == 0){
                    for (int y : adj[x]) {
                        satisfaction[y]--;
                    }
                }
            }
        }
        if (abnormal) {
            System.out.println("Lier!");
        }else{
            System.out.println("King-God-Emperor");
        }
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static int[] indeg, cnt, satisfaction;
    static ArrayList<Integer>[] adj;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        adj = new ArrayList[n + 1];
        indeg = new int[n + 1];
        cnt = new int[n + 1];
        satisfaction = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

}
