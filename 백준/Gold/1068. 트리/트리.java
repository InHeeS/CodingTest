import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    static int n, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        // 인접 리스트에서 각 서브노드에서 가지고 erased 노드의 위치를 지워준다. 
        for (int i = 0; i < n; i++) {
            if (child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }

        // root 노드가 사라졌을 때
        if (root != erased)
            dfs(root);

        System.out.println(leaf[root]);
    }

    private static void dfs(int x) {
        if (child[x].isEmpty()){
            leaf[x] = 1;
        }
        for (int y : child[x]) {
            dfs(y);
            leaf[x] += leaf[y];

        }
    }

    private static void input() {
        n = sc.nextInt();
        child = new ArrayList[n];
        leaf = new int[n];
        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int par = sc.nextInt();
            if (par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = sc.nextInt();
    }

}
