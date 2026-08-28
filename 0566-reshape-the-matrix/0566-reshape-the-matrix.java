class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // Total elements same hone chahiye
        if (m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];

        for (int i = 0; i < m * n; i++)  // i = 0  1  2  3
        {
            // Original matrix se element
            int value = mat[i / n][i % n];

            // New matrix mein position
            ans[i / c][i % c] = value;
        }
        return ans;
    }
}

/*
| i | i/n   | i%n   | Element |
| - | ----: | ----: | ------: |
| 0 |     0 |     0 |       1 |
| 1 |     0 |     1 |       2 |
| 2 |     1 |     0 |       3 |
| 3 |     1 |     1 |       4 |
*/