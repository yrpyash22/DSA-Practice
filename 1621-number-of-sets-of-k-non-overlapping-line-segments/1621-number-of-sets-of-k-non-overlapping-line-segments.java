class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        
        long dp[][] = new long[n][k+1];

        // 0 segments banane ka 1 way: kuch bhi select na karna
        for(int i = 0; i<n; i++)
        {
            dp[i][0] = 1;
        }

        for(int j=1; j<=k; j++)
        {
            long prefix = 0;

            for(int i = 1; i<n; i++)
            {
                // dp[i - 1][j - 1] ko prefix mein add karo
                prefix = (prefix + dp[i -1][j-1]) % MOD;
                // Current point ko last segment ka endpoint banane ke ways
                dp[i][j] = (dp[i-1][j] + prefix) % MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}