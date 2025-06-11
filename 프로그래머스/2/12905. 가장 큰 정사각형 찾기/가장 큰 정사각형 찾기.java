class Solution
{

    public int solution(int [][]board) {
        int max = 0;
        int rows = board.length;
        int cols = board[0].length;
        // board[i][j] = 해당 위치에서 만들 수 있는 최대 정사각형의 한변의 길이
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1){
                    board[i][j] = Math.min(
                        Math.min(board[i - 1][j], board[i][j - 1]),
                        board[i - 1][j - 1]
                    ) + 1;
                }
                max = Math.max(max, board[i][j]);
            }
        }
        // 가장자리(0번째 행/열)에 1이 있을 수도 있으니 max 업데이트
        // 1 * 1 정사각형이 있을 수 있기 떄문에 
        for (int i = 0; i < rows; i++) max = Math.max(max, board[i][0]);
        for (int j = 0; j < cols; j++) max = Math.max(max, board[0][j]);

        return max * max;
    }
}