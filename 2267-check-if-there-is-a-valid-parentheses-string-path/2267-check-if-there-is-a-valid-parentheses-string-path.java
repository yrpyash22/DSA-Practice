class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        // grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]

        int m = grid.length;          //  4
        int n = grid[0].length;       //  3

        // if(grid length is odd) then false
        if((m+n-1) % 2 != 0)   // (6 %2 != 0)!
        {
            return false;
        }

        Set<Integer> dp[][] = new HashSet[m][n];

        for(int i =0; i<m; i++)             // 0, 1, 2, 3
        {
            for(int j =0; j<n ; j++)        // 0, 1, 2
            {
                dp[i][j] = new HashSet<>();

                int change;
                if(grid[i][j] == '(') 
                {
                    change = 1;
                }
                else{
                    change = -1;
                }

                // Start cell
                if(i ==0 && j==0) 
                {
                    if(change == 1)
                    {
                        dp[i][j].add(1);  
                    }
                    continue;
                }

                // Upar se aana
                if(i > 0)
                {
                    for(int balance : dp[i - 1][j])
                    {
                        int newBalance = balance + change;
                        if (newBalance >= 0)
                        {
                            dp[i][j].add(newBalance);
                        }
                    }
                }

                // Left se aana
                if(j > 0)
                {
                    for (int balance : dp[i][j - 1])
                    {
                        int newBalance = balance + change;
                        if (newBalance >= 0)
                        {
                            dp[i][j].add(newBalance);
                        }
                    }
                }
            }
        }

        if(dp[m-1][n-1].contains(0))
        {
            return true;
        }
        return false;
    }
}