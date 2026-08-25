class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // Answer arr
        int ans[] = new int[n];

        // Step 1: Prefix Product
        // First element ke left mein kuch nahi hai product 0 na aye isliye
        ans[0] = 1;

        // ans[i] mein left side ke saare elements ka product store hoga
        for(int i=1; i<n; i++ )
        {
            ans[i] = ans[i-1] * nums[i-1];
        }

        // Example:
        // nums = [1, 2, 3, 4]   ans = [1, 1, 2, 6]
        // ans[0] = 1
        // ans[1] = 1
        // ans[2] = 1 * 2 = 2
        // ans[3] = 1 * 2 * 3 = 6


        // Step 2: Suffix Product
        // ans[i] mein already LEFT side ka product hai.
        // suffix mein RIGHT side ka product hai.
        int suffix = 1;
        // Dono multiply karne par nums[i] ko chhodkar sabka product mil jayega.
        for (int i = n - 1; i >= 0; i--)
        {
            ans[i] = ans[i] * suffix;

            // Current element ko suffix product mein add karo
            suffix = suffix * nums[i];
        }
        return ans;
    }
}