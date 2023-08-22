class Solution {
    public int solution(String s) {
        String[] str = s.split("");
        int rs =0, same =0, diff =0;
        
        String comp = str[0];
        for (String value : str) {
            if (same == diff) {
                rs++;
                comp = value;
            }
            if (comp.equals(value)) same++;
            else diff++;
        }
        return rs;
    }
}