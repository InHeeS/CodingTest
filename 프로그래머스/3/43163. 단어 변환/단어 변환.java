import java.util.LinkedList;
import java.util.Queue;
class Solution {
public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.word.equals(target)) {
                return cur.depth;
            }
            for (int i = 0; i < words.length; i++) {
                if(!visited[i] && differByOne(cur.word, words[i])){
                   visited[i] = true;
                   queue.add(new Node(words[i], cur.depth + 1));
                }
            }
        }

        return 0;
    }

    private boolean differByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++diff > 1){
                return false;
            }
        }
        return diff == 1;
    }

    private static class Node{
        String word;
        int depth;

        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}