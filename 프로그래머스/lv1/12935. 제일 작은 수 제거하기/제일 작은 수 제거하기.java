class Solution {
    public int[] solution(int[] arr) {
        int[] emp = {-1};
        if(arr.length == 0 || arr.length == 1)
            return emp;
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (min > j)
                min = j;
        }
        int[] rs = new int[arr.length -1];
        int j =0;
        for (int k : arr) {
            if (min != k)
                rs[j++] = k;
        }
        return rs;
    }
}