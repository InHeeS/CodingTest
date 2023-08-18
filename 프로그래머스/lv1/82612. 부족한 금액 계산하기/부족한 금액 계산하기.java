class Solution {
    public long solution(int price, int money, int count) {
        long tmp = money;
        for (int i = 1; i <= count; i++) {
            tmp  -= (long) price * i;
        }
        if(tmp >= 0)
            return 0;
        return -tmp;
    }
}