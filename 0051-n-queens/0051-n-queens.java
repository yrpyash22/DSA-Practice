class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> r = new ArrayList<>();

        char board[][] = new char[n][n];

        // Initialize all board empty
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, r);

        return r;
    }


    public void backtrack( char board[][], int row, List<List<String>> r)
    {
        // Saari rows mein queen place ho gayi
        if(row == board.length)
        {
            List<String> solution = new ArrayList<>();

            for(int i = 0; i < board.length; i++)
            {
                solution.add(new String(board[i]));
            }
            
            r.add(solution);
            return;
        }


        // Current row mein har column try karo
        for(int col = 0; col < board.length; col++)
        {
            // Check queen safe hai ya nahi
            if(isSafe(board, row, col))
            {
                // Queen place
                board[row][col] = 'Q';

                // Next row
                backtrack(board, row + 1, r);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }


    public boolean isSafe(char board[][], int row, int col)
    {

        // 1. Vertical / Same Column
        for(int i = row - 1; i >= 0; i--)
        {
            if(board[i][col] == 'Q')
            {
                return false;
            }
        }


        // 2. Diagonal Left Up
        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0;
            i--, j--)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }


        // 3. Diagonal Right Up
        for(int i = row - 1, j = col + 1;
            i >= 0 && j < board.length;
            i--, j++)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
        }

        return true;
    }
}