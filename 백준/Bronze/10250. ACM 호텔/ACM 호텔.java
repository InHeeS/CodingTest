import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int T, i =0, rs;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while(i++ < T){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            if(N % H  != 0){
                rs = (N % H) * 100 + ((N / H) + 1);
                System.out.println(rs);
            }else {
                rs = (H * 100) + (N / H);
                System.out.println(rs);
            }
        }
    }
}
