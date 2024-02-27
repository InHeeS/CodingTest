class Solution {
    static int[] answer = new int[2];

    
    public static int[] solution(int[][] arr) {

        comp(arr, 0, 0, arr.length);
        return answer;
    }

    private static void comp(int[][] arr, int x, int y, int length) {
        if (isComp(arr,x,y,length)){
            answer[arr[x][y]]++;
            return;
        }
        comp(arr, x, y, length/2);
        comp(arr, x + length/2, y, length/2);
        comp(arr, x, y + length/2, length/2);
        comp(arr, x + length/2, y + length/2, length/2);
    }

    private static boolean isComp(int[][] arr, int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if(arr[x][y] != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}