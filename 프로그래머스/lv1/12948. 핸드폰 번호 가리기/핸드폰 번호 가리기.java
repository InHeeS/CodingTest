class Solution {
    public String solution(String phone_number) {
        String back_number = phone_number.substring(phone_number.length() -4, phone_number.length());
        String front_number = phone_number.substring(0, phone_number.length() -4);
        String str = front_number.replaceAll("[0-9]","*");
        return str + back_number;
    }
}