class Solution {
    public int minimizeSum(int[] nums) {
        
        // nums = [1, 4, 7, 8, 5]

        Arrays.sort(nums);  // [1, 4, 5, 7, 8]

        int n = nums.length;           // 5
        int ans = Integer.MAX_VALUE;

        // Case 1: Change two smallest
        ans = Math.min(ans, nums[n - 1] - nums[2]);  // (., 8-5)3

        // Case 2: Change smallest and largest
        ans = Math.min(ans, nums[n - 2] - nums[1]);  // (3, 7-4)3

        // Case 3: Change two largest
        ans = Math.min(ans, nums[n - 3] - nums[0]);  // (3, 5-1)3

        return ans;   //3
    }
}