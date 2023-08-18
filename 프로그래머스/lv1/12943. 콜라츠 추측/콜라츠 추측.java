class Solution {
    public int solution(int num) {
        int cnt =0;
        long tmp = num;
        while(true){
            if(tmp == 1)
                return cnt;
            if(cnt == 500)
                break;
            if(tmp % 2 == 0){
                tmp /= 2;
            }else{
                tmp *= 3;
                tmp += 1;
            }
            cnt++;
        }
        return -1;
    }
}