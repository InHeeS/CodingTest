class Solution {
    public long solution(int[] sequence) {
        long curr1 = 0, max1 = Long.MIN_VALUE;
        long curr2 = 0, max2 = Long.MIN_VALUE;

        for (int i = 0; i < sequence.length; i++) {
            long x1 = sequence[i] * (i % 2 == 0 ? 1 : -1);
            long x2 = sequence[i] * (i % 2 == 0 ? -1 : 1);

            // 현재의 합과 새로운 단일 변수와의 비교
            curr1 = Math.max(x1, curr1 + x1);
            // curr1 의 값은 max1 보다 작을 수 있지만 다음턴에 커질 수도 있음
            max1 = Math.max(max1, curr1);

            curr2 = Math.max(x2, curr2 + x2);
            max2 = Math.max(max2, curr2);
        }

        return Math.max(max1, max2);
    }
}