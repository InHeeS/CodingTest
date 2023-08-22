import java.util.stream.IntStream;
class Solution {
    public int solution(int[] nums) {
 // 중복된 숫자가 들어있지 않다.
        // 1000000000 < int
        // Prime number
        int cnt = 0;
        for(int i=0; i< nums.length-2; i++){
            for(int j=i+1;j < nums.length -1; j++){
                for(int k = j +1; k < nums.length; k++){
                   if(is_prime(nums[i] + nums[j] + nums[k]))
                       cnt++;
                }
            }
        }
        return cnt;
    }
        public static boolean is_prime(int num){
        return IntStream.range(2, num).noneMatch(i -> num % i == 0);
    }
}