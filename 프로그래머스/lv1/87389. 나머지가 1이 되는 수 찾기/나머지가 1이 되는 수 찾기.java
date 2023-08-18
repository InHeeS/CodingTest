class Solution {
    public int solution(int n) {
            int rs = 0;
        for(int i= 1 ; i < n; i++){
            if(n % i == 1) {
                rs = i;
                break;
            }
        }
        return rs;
    }
}