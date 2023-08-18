class Solution {
    public int solution(int[] a, int[] b) {
        int rs =0;
        for(int i=0; i< a.length ;i++){
            rs += a[i] * b[i];
        }
        return rs;
    }
}