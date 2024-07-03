
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] nyang = sc.next().toCharArray();
        int L = nyang.length;

        int nextIndex = 0;
        int[] frequency = new int[26];
        int ans = 0;
        for (int i = 0; i < L; i++) {
            while(nextIndex < L){
                frequency[nyang[nextIndex++] - 'a']++;
                if (getAlphabetCount(frequency) > N) {
                    frequency[nyang[--nextIndex] - 'a']--;
                    break;
                }
            }
            ans = Math.max(ans, nextIndex - i);
            frequency[nyang[i] - 'a']--;
        }
        System.out.println(ans);

    }

    static int getAlphabetCount(int[] frequency) {
        int unique = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                unique++;
            }
        }
        return unique;
    }

}
