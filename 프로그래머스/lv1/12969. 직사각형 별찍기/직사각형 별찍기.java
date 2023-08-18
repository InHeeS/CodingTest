import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        for(int i=1; i<=row; i++){
            for(int j =1 ; j<=col; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}