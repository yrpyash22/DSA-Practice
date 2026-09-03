class Solution {
    public boolean checkValidGrid(int[][] grid) {

        // Knight must start from top-left
        if(grid[0][0] != 0)
        {
            return false;
        }

        return solve(grid, 0, 0, 1);
    }


    public boolean solve(int grid[][], int row, int col, int move)
    {
        int n = grid.length;  // 5

        // All cells visited
        if(move == n*n) 
        {
            return true;
        }

        // 8 possible knight moves
        int directions[][] = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        // Try all 8 possible moves
        for(int i =0; i<8; i++)
        {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

             // Check boundary
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) 
            {
                // Check whether this cell contains the next move number
                if(grid[newRow][newCol] == move) 
                {
                    // Recursion
                    if(solve(grid, newRow, newCol, move + 1)) 
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}