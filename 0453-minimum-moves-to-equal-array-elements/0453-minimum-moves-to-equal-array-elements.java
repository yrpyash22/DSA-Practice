class Solution {
    public int minMoves(int[] nums) {

        // nums = [1,2,3]
        
        int n = nums.length;   // 3

        int min = nums[0];     // 1

        for(int i=1; i<n; i++)   // 1,2
        {
            min = Math.min(nums[i], min);  //(2,1)1, (3,1)1
        }

        int moves= 0;

        for(int i=0; i<n; i++)   //0, 1, 2
        {
            moves = moves + nums[i] - min;   //[0+1-1]0, [0+2-1]1, [1+3-1]3
        }

        return moves;    // 3
    }
}