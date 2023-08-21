class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI","SAT","SUN","MON", "TUE", "WED", "THU"};
                int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};


        int cnt = -1;// 1일 부터 시작
        for(int i=0; i< a -1 ;i++){
            cnt += month[i];
        }
        return day[(cnt + b) % 7];
    }
}