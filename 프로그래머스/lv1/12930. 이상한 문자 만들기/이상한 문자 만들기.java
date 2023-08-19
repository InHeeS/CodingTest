class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        int cnt =0;
        String rs = "";

        for(int i =0 ; i< str.length; i++){
            if(str[i].contains(" "))
                cnt =0;
            else
                cnt++;

            if(cnt % 2 != 0){
                rs += str[i].toUpperCase();
            }else
                rs += str[i].toLowerCase();
        }
        return rs;
    }
}