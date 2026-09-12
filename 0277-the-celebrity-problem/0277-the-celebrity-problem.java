class Solution {
    public int celebrity(int mat[][]) {

        int n = mat.length;

        // Step 1: Find a possible celebrity
        int candidate = 0;

        for (int i = 1; i < n; i++) 
        {
            // If candidate knows i, candidate cannot be celebrity
            if (mat[candidate][i] == 1)
            {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) 
        {
            if (i != candidate) 
            {
                // Celebrity should not know anyone and everyone should know celebrity
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0)
                {
                    return -1;
                }
            }
        }
        return candidate;
    }
}
