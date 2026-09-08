class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        
        int n = nums.length;
        
        int maxVal = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int i = k; i < n; i++)
        {
            maxVal = Math.max(maxVal, nums[i - k]);

            ans = Math.max(ans, maxVal + nums[i]);
        }

        return ans;
    }
}