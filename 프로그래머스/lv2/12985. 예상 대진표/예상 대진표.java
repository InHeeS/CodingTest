class Solution
{
    public int solution(int n, int a, int b)
    {
        // n?
        int cnt =0;
        while(true){
            if(a == b)break;
            
            a = (a + 1) / 2; // 1,2 = 3, 4
            b = (b + 1) / 2;
            cnt++;
        }

        return cnt;
    }
}