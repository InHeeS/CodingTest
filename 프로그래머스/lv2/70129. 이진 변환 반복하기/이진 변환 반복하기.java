class Solution {
    
    static int zeroCnt =0;
    static int binaryCnt =0;
    
    public int[] solution(String s) {
   int[] rs = new int[2];
        delZero(s);
        rs[0] = binaryCnt;
        rs[1] = zeroCnt;
        return rs;
    }
    public static String delZero(String s){

        //return;
        if(s.equals("1"))
            return "";

        int cnt =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0')
                cnt++;
        }
        zeroCnt += cnt;
        int len = s.length() - cnt;
        binaryCnt++;

        return delZero(Integer.toString(len, 2));
    }
}