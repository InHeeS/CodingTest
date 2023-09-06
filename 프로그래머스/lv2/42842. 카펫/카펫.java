class Solution {
    public int[] solution(int brown, int yellow) {
        // yellow -> row, col : yellow / row
        // brownCnt -> (row + col) * 2 + 4
        int[] rs = new int[2];
        int col;
        // col >= row
        int maxRow = (int)Math.sqrt(yellow);
        for(int i=1; i<= maxRow ;i++){
            if(yellow % i != 0)
                continue;
            col = yellow / i;
            if((col + i) * 2 + 4 == brown) {
                rs[0] = col + 2;// 꼭지점 + 2
                rs[1] = i + 2;
                break;
            }
        }

        return rs;
    }
}