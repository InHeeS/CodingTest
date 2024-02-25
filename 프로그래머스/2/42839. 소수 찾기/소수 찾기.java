import java.util.HashSet;
import java.util.Set;
class Solution {
        static boolean[] visited = new boolean[7];
    static Set<Integer> primeSet = new HashSet<>();
    public static int solution(String numbers){
        // dfs 완전 탐색
        int answer = 0;
        dfs(numbers, "", 0);
        for (Integer num : primeSet) {
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;

    }

    private static boolean isPrime(Integer num) {
        if(num < 2){
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num % i ==0)
                return false;

        }
        return true;
    }

    public static void dfs(String numbers, String s, int depth){
        if(depth > numbers.length())
            return ;
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                primeSet.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }

        }
    }
}