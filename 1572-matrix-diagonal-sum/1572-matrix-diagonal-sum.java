class Solution {
    public int diagonalSum(int[][] matrix) {
        int sum = 0;
        // upper loop for row searching
        for(int i = 0; i<matrix.length; i++)
        {
            // for columsn searching
            for(int j =0; j<matrix[0].length; j++)
            {
                // Primary diagonal sum
                if(i==j)
                {
                    sum = sum + matrix[i][j];
                }
                else if(i+j == matrix.length - 1) // Secondary diagonal sum
                {
                    sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }
}