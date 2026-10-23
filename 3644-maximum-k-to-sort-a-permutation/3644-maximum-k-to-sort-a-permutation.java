class Solution {
    public int sortPermutation(int[] nums) {

        // Input: nums = [0,1,3,2]
        
        int n = nums.length;   // 4
        int k = -1;

        for(int i=0; i<n; i++)    // 0,1,2,3
        {
            if(nums[i] != i)
            {
                if(k == -1)
                {
                    k = nums[i] & i;
                } 
                else {
                    k = k & nums[i] & i;
                }
            }
        }

        if(k == -1)
        {
            return 0;
        }
        else{
            return k;   // 2
        }
    }
}