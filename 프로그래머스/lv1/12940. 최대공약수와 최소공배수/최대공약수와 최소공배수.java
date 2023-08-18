class Solution {
    public int[] solution(int n, int m) {
        // 최대 공약수, 최대 공배수
        int[] rs = new int[2];
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        int tmp_n = n;
        int tmp_m = m;
        while (tmp_n > 0) {
            int a = tmp_m % tmp_n;
            tmp_m = tmp_n;
            tmp_n = a;
        }
        rs[0] = tmp_m;
        rs[1] = n * m / rs[0];
        System.out.println(rs[0]);
        System.out.println(rs[1]);
        
        return rs;
    }
}