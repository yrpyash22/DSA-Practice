class Solution {
    public int orangesRotting(int[][] grid) {
        
        // Input: grid = [[2,1,1],[1,1,0],[0,1,1]]

        int m = grid.length;     // 3
        int n = grid[0].length;  // 3

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0; i<m; i++)   // 0,1,2
        {
            for(int j =0; j<n; j++)   // 0,1,2
            {
                if(grid[i][j] == 2)             // (2==2), (1)!, (1)! ..., (1)!
                {
                    q.add(new int[]{i, j});      //[{0,0},]
                }

                if(grid[i][j] == 1)             //(2=1)!, (1), (1), ... ,(1)
                {
                    fresh++;                    // 1, 2,3,4,5, 6
                }
            }
        }

        int min = 0;

        // Check for Four directions
        int direction[][] = {
            {-1, 0},    // up
            {1, 0},     // down
            {0, -1},    // left
            {0, 1}      // right
        };



        // BFS
        while(!q.isEmpty() && fresh > 0)  // (T&6>0)
        {
            int size = q.size();         // 1

            // Pocess for one min
            for(int i = 0; i<size; i++)   // 0
            {
                int curr[] = q.remove();  // {0,0}

                int row = curr[0];     // 0
                int col = curr[1];     // 0


                // their is check 4 direction
                for(int dir[] : direction)  // 0,1,2,3
                {
                    int newRow = row + dir[0];   // -1, 1, 0, 0
                    int newCol = col + dir[1];   //  0, 0, -1, 1

                    // check boundry
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n  && grid[newRow][newCol] == 1) //(1>0 & 1<3 & 0=0 & 0<3 & 1==1)
                    {
                        // Make fresh orange rotten
                        grid[newRow][newCol] = 2;
                        fresh--;         // 5, 4

                        // Add newly rotten orange
                        q.add(new int[]{newRow, newCol});  // [{0,0}, {1,0}, {0,1}]
                    }
                }
            }
            min++;  // 1
        }

        // If fresh oranges are still remaining
        if(fresh > 0)
        {
            return -1;
        }

        return min;
    }
}