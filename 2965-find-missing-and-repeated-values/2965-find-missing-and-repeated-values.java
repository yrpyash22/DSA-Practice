class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // For first example based
        // grid length
        int n = grid.length;                     // 2
        int total_val = n * n;                   // 4

        int[] freq = new int[total_val + 1];     // 5

        // find frequency count of each number
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++) 
            {
                freq[grid[i][j]]++;   // [0[0], 1[1], 2[2], 1[3], 0[4], 0[5]]
            }
        }

        int repeated_val = -1;
        int missing_val = -1;

        // Find repeated and missing value
        for (int i = 1; i <= total_val; i++) 
        {
            if(freq[i] == 2) 
            {
                repeated_val = i;       // 2
            } 
            else if (freq[i] == 0) 
            {
                missing_val = i;        // 4
            }
        }

        return new int[]{repeated_val, missing_val};
    }
}