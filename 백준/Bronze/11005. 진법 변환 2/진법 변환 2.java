
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        // 1. N 을 B 로 나누 나머지를 구하고 B 를 구하자
        // 2. 이때 가장 마지막 나머지부터 가장 앞 자리값이 된다.

        String ans = "";
        while (N > 0){
            int D = N % B;
            if (D < 10)ans += D;
            else ans += (char)(D - 10 + 'A');
            N = N / B;

        }

        for (int i = ans.length() - 1; i >= 0 ; i--) {
            System.out.print(ans.charAt(i));
        }
    }



}
