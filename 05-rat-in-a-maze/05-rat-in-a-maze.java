class Solution {

     public ArrayList<String> ratInMaze(int[][] maze) {

         ArrayList<String> ans = new ArrayList<>();
         int n = maze.length;

         // Start ya destination blocked hai
         if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) 
         {
             return ans;
         }

         boolean visited[][] = new boolean[n][n];

         solve(0, 0, maze, visited, "", ans);

         return ans;
     }

     public void solve(int row, int col, int maze[][], boolean visited[][], String path, ArrayList<String> ans) 
     {

         int n = maze.length;

         // Base Case
         if (row == n - 1 && col == n - 1)
         {
             ans.add(path);
             return;
         }

         // Current cell ko visited mark karo
         visited[row][col] = true;

         // Down
         if (isSafe(row + 1, col, maze, visited)) 
         {
             solve(row + 1, col, maze, visited, path + "D", ans);
         }

         // Left
         if (isSafe(row, col - 1, maze, visited)) {
             solve(row, col - 1, maze, visited,
                   path + "L", ans);
         }

         // Right
         if (isSafe(row, col + 1, maze, visited)) {
             solve(row, col + 1, maze, visited,
                   path + "R", ans);
         }

         // Up
         if (isSafe(row - 1, col, maze, visited)) {
             solve(row - 1, col, maze, visited,
                   path + "U", ans);
         }

         // BACKTRACK
         visited[row][col] = false;
     }

     public boolean isSafe(int row, int col, int maze[][], boolean visited[][]) 
     {
         int n = maze.length;

         return row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col];
     }
 }

