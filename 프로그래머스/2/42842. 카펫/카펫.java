class Solution {
    public int[] solution(int brown, int yellow) {
        /**
         * 전체 칸 수 = brown + yellow
         * 내부 노란 칸 수 = (가로 – 2) × (세로 – 2) = yellow
         */
        int total = brown + yellow;

        for (int width = 3; width < total; width++) {
            for (int height = 3; height <= width; height++) {
                if (width * height != total) continue;
                
                if ((width - 2) * (height - 2) == yellow){
                    return new int[]{width, height};
                }
            }
        }
        
        return null;
    }
}