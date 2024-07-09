
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        int openCount = 0; // 지나온 쇠막대기의 개수 
        // 즉 레이저를 만나게 되면 지나온 개수많큼 더해주기 
        int ans =0; // 쇠막대기
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                openCount++;
            } else if (input[i] == ')') {
                openCount--;
                if (input[i - 1] == '(') {
                    ans += openCount;
                    /**
                     * ((()))
                     * ------
                     *  ----
                     * --- ---
                     *  -- --
                     *  2 + 2 = 4개
                     */
                }else
                    ans++; // 쇠막대기 개수 늘려주기
            }
        }
        System.out.println(ans);

    }

}
