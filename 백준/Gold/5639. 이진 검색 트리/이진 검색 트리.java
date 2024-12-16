import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> a;


    private static void pro() {
        traverse(0, a.size() -1);
        System.out.println(sb);
    }

    private static void traverse(int l, int r) {
        if (l > r)return;
        int mid = r;// subtree 의 왼쪽 오른쪽을 가르는 기준 위치를 나타내는 변수
        for (int i = l + 1; i <= r; i++) {
            if (a.get(i) > a.get(l)){
                mid = i - 1;
                break;
            }
        }

        traverse(l + 1, mid);
        traverse(mid + 1, r);
        // 전위 순회의 순서상 가장 먼저 만난 작은 수
        // l 은 1씩 증가 가장 작은 수를 찾는 로직
        sb.append(a.get(l)).append("\n");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        while((input = br.readLine()) != null){
            a.add(Integer.parseInt(input));
        }
    }

}
