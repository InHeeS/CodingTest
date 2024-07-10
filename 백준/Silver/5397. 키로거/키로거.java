
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            char[] input = sc.next().toCharArray();

            // beforeCursor 오른쪽 입구
            // afterCursor 왼쪽 입구
            // 즉 스택이라고 생각
            Deque<Character> beforeCursor = new ArrayDeque<>();
            Deque<Character> afterCursor = new ArrayDeque<>();
            for (char cmd : input) {
                if (cmd == '-'){
                    if (!beforeCursor.isEmpty()) {
                        beforeCursor.removeLast();
                    }
                } else if (cmd == '<') {
                    if (!beforeCursor.isEmpty()){
                        afterCursor.addLast(beforeCursor.removeLast());
                    }
                } else if (cmd == '>') {
                    if (!afterCursor.isEmpty()){
                        beforeCursor.addLast(afterCursor.removeLast());
                        // a | b c
                    }

                } else{
                    beforeCursor.addLast(cmd);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!beforeCursor.isEmpty()) sb.append(beforeCursor.removeFirst());
            while(!afterCursor.isEmpty()) sb.append(afterCursor.removeLast());
            System.out.println(sb);

        }
    }

}
