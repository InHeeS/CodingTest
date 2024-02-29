class Solution {
       public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int answerLeftPos = 0;
        int answerRightPos = sequence.length - 1;


        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            // 부분 수열의 합이 k보다 크면
            while (sum > k) {
                // 부분 수열의 합이 k보다 작을 때까지 왼쪽 인덱스값 증가
                sum -= sequence[left];
                left++;
            }

            // 부분 수열의 합이 k랑 같을때
            if (sum == k) {
                // 길이가 더 짧은 수열이 있으면
                if ((right - left) < (answerRightPos - answerLeftPos)) {
                    answerRightPos = right;
                    answerLeftPos = left;
                }
                // 길이가 짧은 수열이 여러 개인 경우, 앞쪽에 나오는 수열을 찾는다.
                if ((right - left) == (answerRightPos - answerLeftPos) && answerLeftPos > left) {
                    answerRightPos = right;
                    answerLeftPos = left;
                }
            }

        }
        return new int[]{answerLeftPos, answerRightPos};
    }
}