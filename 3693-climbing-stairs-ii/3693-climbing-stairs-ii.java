class Solution {
    public int climbStairs(int n, int[] costs) {

        // n = 4 ,  costs = [1, 2, 3, 4]

        int dp[] = new int[n+1];     // 5
        dp[0] = 0;

        for(int i =1; i<=n; i++)  // 1, 2, 3, 4
        {
            dp[i] = Integer.MAX_VALUE;

            for(int j=1; j<=3; j++)      // 1, 2, 3
            {
                if(i-j >= 0)    //(0=0),(-1)!,(-2)!,(-3)! | (1),(0),(-1)!,(-2)! |  . ... 
                {
                    int cost = dp[i-j] + costs[i-1] + j*j;  // [0+1+1]2, [2+2+1]5, [0+2+4]6, [5+3+1]9 ,[2+3+4]9, [0+3+9]12,  .....

                    dp[i] = Math.min(dp[i], cost);  // (0,2)0, (2,5)2, (5,6)5, (12,9)9,  .....()13
                }
            }
        }
        return dp[n];    // 13
    }
}