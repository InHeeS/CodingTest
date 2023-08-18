class Solution {
    public long solution(int a, int b) {
        if(b < a){
            int tmp = a;
            a = b;
            b = tmp;
        }
        long sum =0;
        for(int i = a; i <= b ; i++){
            sum += i;
        }
        return sum;
    }
}