class Solution {
    public boolean exist(char[][] board, String word) {
        // word = "ABCCED"
        int m = board.length;       // Row
        int n = board[0].length;    // Col

        // Har cell ko starting point maan kar check karo
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                // Agar first char match ho gaya to fir
                if(board[i][j] == word.charAt(0))
                {
                    // Apply dfs / backtraking
                    if(dfs(board, word, i, j, 0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index)
    {
        // Step 1: Word complete ho gaya only one word char
        if (index == word.length())     // (0==6)
        {
            return true;
        }

        // Step 2: Boundary check
        if(i<0 || i >= board.length || j<0 || j >= board[0].length)
        {
            return false;
        }

        // Step 3: Current character match nahi karta
        if(board[i][j] != word.charAt(index))
        {
            return false;
        }

        // Step 4: Current cell ko visited mark karo
        char temp = board[i][j];
        board[i][j] = '#';

        // Step 5: 4 directions mein search karo => Recursive dfs
        boolean found =
                dfs(board, word, i - 1, j, index + 1) ||  // Up
                dfs(board, word, i + 1, j, index + 1) ||  // Down
                dfs(board, word, i, j - 1, index + 1) ||  // Left
                dfs(board, word, i, j + 1, index + 1);     // Right

        // Step 6: Backtracking
        board[i][j] = temp;

        return found;
    }
}