class Solution {
    public int minMoves2(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);

        int mid = nums[n/2];
        int moves = 0;

        for(int i=0; i<n; i++)
        {
            moves = moves + Math.abs(nums[i] - mid);
        }

        return moves;
    }
}