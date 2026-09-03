class Solution {
    public void setZeroes(int[][] matrix) {

        // Ex -> matrix = [[1,1,1],[1,0,1],[1,1,1]]

        int m = matrix.length;       // 3 Rows
        int n = matrix[0].length;   // 3 Columns

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check first row
        for (int i = 0; i < n; i++)   // i = 0,1,2
        {
            if (matrix[0][i] == 0)
            {
                // matrix[0][0] = 1 -> 1 == 0 ! 
                // matrix[0][1] = 1 -> 1 == 0 !
                // matrix[0][2] = 1 -> 1 == 0 !
                firstRowZero = true;
                break;
            }
        }
        // Step 2: Check first column
        for (int i = 0; i < m; i++)   // i = 0,1,2
        {
            if (matrix[i][0] == 0)
            {
                // matrix[0][0] = 1 -> 1 == 0 !
                // matrix[1][0] = 1 -> 1 == 0 !
                // matrix[2][0] = 1 -> 1 == 0 !
                firstColZero = true;
                break;
            }
        }


        // Step 3: Use first row and first column as markers
        for (int i = 1; i < m; i++)       // i = 1,2
        {
            for (int j = 1; j < n; j++)   // j = 1,2
            {
                if (matrix[i][j] == 0)
                {
                    // Example:
                    // matrix[1][1] = 0
                    // Mark this ROW
                    matrix[i][0] = 0;
                    // Mark this COLUMN
                    matrix[0][j] = 0;
                }
            }
        }


        // Step 4: Set rows to zero
        for (int i = 1; i < m; i++)   // i = 1,2
        {
            if (matrix[i][0] == 0)
            {
                // i = 1:
                // matrix[1][0] = 0
                // So Row 1 will become zero
                for (int j = 1; j < n; j++)   // j = 1,2
                {
                    matrix[i][j] = 0;
                }
            }
        }
        // Step 5: Set columns to zero
        for (int j = 1; j < n; j++)   // j = 1,2
        {
            if (matrix[0][j] == 0)
            {
                // j = 1:
                // matrix[0][1] = 0
                // So Column 1 will become zero
                for (int i = 1; i < m; i++)   // i = 1,2
                {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 6: Finally handle first row
        if (firstRowZero)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[0][j] = 0;
            }
        }
        // Step 7: Finally handle first column
        if (firstColZero)
        {
            for (int i = 0; i < m; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}