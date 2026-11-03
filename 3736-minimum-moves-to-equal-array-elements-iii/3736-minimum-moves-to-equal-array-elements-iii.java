class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        int max = nums[0];
        int moves = 0;

        for(int i=1; i<n; i++)
        {
            max = Math.max(nums[i], max);   // 3
        }

        for(int i =0; i<n; i++)
        {
            moves = moves + max - nums[i];   //[0+3-2]1, [1+3-1]3, [3+3-3]3
        }

        return moves;   //3
    }
}