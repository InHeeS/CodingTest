
import java.util.Scanner;

public class Main {

    static int s ;
    static int[] numbers;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        s = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        solve(0, 0);
        System.out.println(answer);
    }

    public static void solve(int index, int sum){

        if (index == numbers.length) return;
        if (sum + numbers[index] == s) answer++;

        solve(index + 1, sum + numbers[index]);
        solve(index + 1, sum);
    }
}
