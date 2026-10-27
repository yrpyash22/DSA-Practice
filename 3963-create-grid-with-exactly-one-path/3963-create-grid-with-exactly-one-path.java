class Solution {
    public String[] createGrid(int m, int n) {

        char arr[][] = new char[m][n];
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                arr[i][j] = '#';
            }
        }

        for(int i =0; i<m; i++)
        {
            arr[i][n-1] = '.';
        }

        for(int j=0; j<n; j++) 
        {
            arr[0][j] = '.';
        }

        String res[] = new String[m];

        for(int i = 0; i < m; i++)
        {
            res[i] = new String(arr[i]);
        }

        return res;
    }
}