import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }

        Arrays.sort(houses);

        int mid = houses[(n - 1) / 2];
        System.out.println(mid);
    }

}