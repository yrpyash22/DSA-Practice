class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;      // 4
        int n = matrix[0].length;   // 3

        int left = 0;
        int right = m * n - 1;      // 11

        while (left <= right)
        {
            int mid = left + (right - left) / 2;  // 0+(11-0)/2=5

            // 1D index ko matrix ke row aur column mein convert kiya hai 
            int row = mid / n; // 5/3=1
            int col = mid % n; // 5%3=2

            if (matrix[row][col] == target)  //([1][2]16==3)
            {
                return true;
            }
            else if (matrix[row][col] < target)  
            {
                left = mid + 1;
            }else {                             // (16 > 3)
                right = mid - 1;
            }
        }
        return false;
    }
}