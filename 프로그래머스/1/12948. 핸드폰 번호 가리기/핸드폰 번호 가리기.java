class Solution {
    public static String solution(String phone_number) {
        String back = phone_number.substring(phone_number.length() -4);
        String front = "*".repeat(phone_number.length() -4);
        return front + back;
    }
}