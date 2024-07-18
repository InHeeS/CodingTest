
import java.util.Scanner;

public class Main {

    static int a, b,c;

    public static void main(String[] args) {
        // 분할
        // 정복
        // 조합
        // power(a,b) -> power(a,b/2) * power(a,b/2) * power(a,1)
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // a ^ b
        System.out.println(power(a, b));
    }

    static long power(long a, long b ){
        if (b == 1) return a % c;
        long half = power(a, b/2);
        if (b % 2 == 0){
            return (half * half) % c;
        }else{
            return (((half * half) % c) * a) % c;
        }
    }

}
