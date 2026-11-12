class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        // Input: nums = [1,4,3,3,2]

        int inc = 1;
        int dec = 1;
        int ans=1;

        for(int i =1; i<nums.length; i++)   // 1, 2, 3, 4 
        {
            if(nums[i] > nums[i-1])   // (4>1), (3>2)
            {
                inc++;                // 2, 2
                dec = 1;              // 1, 1
            }
            else if(nums[i] < nums[i-1])  // (3<4)
            {
                dec++;                // 2
                inc = 1;              // 1
            }
            else{                     // (3=3)
                inc = 1;
                dec = 1;
            }

            ans = Math.max(ans, Math.max(inc, dec));  //(2), (2), (2), (2)
        }

        return ans;  //2
    }
}