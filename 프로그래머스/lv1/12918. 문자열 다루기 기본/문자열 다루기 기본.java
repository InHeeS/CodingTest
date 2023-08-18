class Solution {
    public boolean solution(String s) {
        if(s.length() < 4 || s.length() > 6 || s.length() == 5)
            return false;
        return s.matches("[0-9]+");
    }
}