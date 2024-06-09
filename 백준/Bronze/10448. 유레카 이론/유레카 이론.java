
import java.util.Scanner;

public class Main {

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess(){

        // 1. K보다 작은 삼각수를 모두 구한다.
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1)/ 2;
            if (triangleNumber >= 1000)break;

            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }


        // 2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다.
        boolean[] isSumOfTriangleNumber = new boolean[1001];

        // 두개의 합으로 이루어진 triangleNumber
        for (int i = 0; i < triangleNumberCount; i++) {
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) isSumOfTriangleNumber[sum] = true;
            }
        }
        // 세개의 합으로 이루어진 triangleNumber
        for (int i = 1; i < 1000; i++) {
            if (!isSumOfTriangleNumber[i])continue;

            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = i + triangleNumbers[j];
                if (sum <= 1000) isEurekaNumber[sum] = true;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        preprocess();

        while(T-- > 0){
            int K = sc.nextInt();
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }


    }

}
