class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(ch);
                continue;
            }
            if(ch >= 'a' && ch <= 'z'){
                if(ch + n > 'z')
                    sb.append((char)(ch-26+n));
                else
                    sb.append((char)(ch + n));
            }else {
                if(ch + n > 'Z')
                    sb.append((char)(ch-26+n));
                else
                    sb.append((char)(ch + n));
            }
        }
        return sb.toString();
    }
}