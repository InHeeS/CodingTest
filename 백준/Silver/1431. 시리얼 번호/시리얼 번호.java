import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] serials = new String[n];

        for (int i = 0; i < n; i++) {
            serials[i] = sc.nextLine();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()){
                    return Integer.compare(o1.length(), o2.length());
                }

                int sumA = getDigitSum(o1);
                int sumB = getDigitSum(o2);
                if (sumA != sumB){
                    return Integer.compare(sumA, sumB);
                }

                return o1.compareTo(o2);
            }

            private int getDigitSum(String s){
                int sum = 0;
                for (char c :s.toCharArray()){
                    if (Character.isDigit(c))
                        sum += c - '0';
                }

                return sum;
            }
        });

        for (String serial : serials) {
            System.out.println(serial);
        }
    }

}
