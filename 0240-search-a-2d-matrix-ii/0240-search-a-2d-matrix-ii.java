class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]] , target =5
        int row = 0;
        int col = matrix[0].length-1;      // 4

        while(row < matrix.length && col >= 0) // (0<5 && 4>0), (.&& 3>0), (.&&2>0), (.&&1>0), (1<5 && 1>0)
        {
            if(matrix[row][col] == target)  // (15==5), (11==5), (7==5), (4==5), (5==5)!
            {
                return true;
            }
            else if(target < matrix[row][col])  // (5<15), (11<5), (7<5)
            {
                col--;      // 3, 2, 1
            }
            else{                              // (5>4)
                row++;      // 1
            }
        }
        return false;
    }
}