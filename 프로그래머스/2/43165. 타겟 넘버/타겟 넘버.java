class Solution {
      static int answer = 0;
    //깊이 우선 탐색(dfs)
    public static int solution(int[] numbers, int target) {

        dfs(numbers,target,0,0);
        return answer;
    }

    private static void dfs(int[] numbers, int target, int idx, int sum) {
       if(idx == numbers.length){
           if(target == sum) answer++;
           return;
       }
       dfs(numbers,target,idx + 1, sum + numbers[idx]);
       dfs(numbers,target,idx + 1, sum - numbers[idx]);
    }
}