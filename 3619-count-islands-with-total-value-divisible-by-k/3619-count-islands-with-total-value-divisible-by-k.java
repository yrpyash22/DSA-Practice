// class Solution {
//     public int countIslands(int[][] grid, int k) {
//         int count = 0;
//         int m = grid.length;
//         int n = grid[0].length;

//         for(int i=0; i<m; i++)
//         {
//             for(int j =0; j<n; j++)
//             {
//                 if(grid[i][j] > 0)
//                 {
//                     int sum = dfs(grid, i, j);

//                     if(sum % k == 0)
//                     {
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }


//     public static int dfs(int grid[][], int i, int j)
//     {
//         if(i< 0 || j<0 || grid.length <= i || grid[0].length <= j)
//         {
//             return 0;
//         }

//         // It is water
//         if(grid[i][j] == 0)
//         {
//             return 0;
//         }
        
//         int val = grid[i][j];
//         grid[i][j] = 0;   // Mark as visited

//         val = val + dfs(grid, i-1, j);
//         val = val + dfs(grid, i+1, j);
//         val = val + dfs(grid, i, j-1);
//         val = val + dfs(grid, i, j+1);

//         return val;
//     }
// }


class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(grid[i][j] > 0)
                {
                    long sum = 0;

                    Stack<Integer> stack = new Stack<>();
                    stack.push(i * n + j);

                    sum = sum + grid[i][j];
                    grid[i][j] = 0;

                    while (!stack.isEmpty()) 
                    {
                        int cell = stack.pop();
                        int r = cell / n;
                        int c = cell % n;

                        for (int d = 0; d < 4; d++) 
                        {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0)
                            {
                                sum = sum + grid[nr][nc];
                                stack.push(nr * n + nc);
                                grid[nr][nc] = 0;
                            }
                        }
                    }

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}