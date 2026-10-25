class Solution {
    public int closedIsland(int[][] grid) {
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    if(dfs(grid, i, j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static boolean dfs(int grid[][], int i, int j)
    {
        if(i< 0 || j<0 || grid.length <= i || grid[0].length <= j)
        {
            return false;
        }

        // Water or already visited
        if(grid[i][j] == 1)
        {
            return true;
        }
        
        grid[i][j] = 1;   // Mark as visited

        boolean up = dfs(grid, i-1, j);
        boolean down = dfs(grid, i+1, j);
        boolean left = dfs(grid, i, j-1);
        boolean right = dfs(grid, i, j+1);

        return up && down && left && right;
    }
}