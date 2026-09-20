class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length();

        boolean palin[][] = new boolean[n][n];

        // create a plaindorm tablel
        for(int len =1; len<=n; len++)
        {
            for(int i = 0; i+len-1 < n; i++)
            {
                int j = i + len -1;

                if(s.charAt(i) == s.charAt(j))
                {
                    if(len <= 2)
                    {
                        palin[i][j] = true;
                    }
                    else{
                        palin[i][j] = palin[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = maximum number of palindromes using first i characters
        int[] dp = new int[n + 1];

        for(int i =1; i<=n; i++)
        {
            // Don't select a palindrome ending at i-1
            dp[i] = dp[i - 1];

            for (int j = 0; j <= i - k; j++)
            {
                // s[j...i-1] is a palindrome and its length is at least k
                if(palin[j][i - 1])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}