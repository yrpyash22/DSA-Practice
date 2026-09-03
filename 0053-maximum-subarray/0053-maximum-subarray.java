class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;

        for(int i = 0; i < n; i++)  // (0, 1, 2, 3, 4)
        {       
            // int curr_sum = 0;
            // for(int j = i; j < n; j++) 
            // {   // (0,1,2,3,4), (1,2,3,4), (2,3,4,5), (3,4,5),..
            //     curr_sum = curr_sum + nums[j]; 
            //     System.out.println(curr_sum);
            //     if(max_sum < curr_sum) {
            //         max_sum = curr_sum;     // 5, 9, 15, 23
            //     }
            // }

            // By Kadanes Algorithm
            curr_sum = Math.max(nums[i], curr_sum + nums[i]);
            max_sum = Math.max(curr_sum, max_sum);
        }

        return max_sum;
    }
}